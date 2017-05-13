package com.example.stus.jacob.subtitlesLogic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by anatoly on 07.05.17.
 */
public class Parser {

    private static final String CITE_URL = "https://isubtitles.net/";
    private static final String SEARCH_PREFIX = "search?kwd=";
    private static final String POSTER_QUERY = "div[class=col-lg-6 col-md-8 col-sm-6]";
    private static final String TITLE_QUERY = "div[class=col-lg-18 col-md-16 col-sm-18]";
    private static final String GARBAGE_FILE = "isubtitles.net.txt";

    public static Document getSearchResults(String request) throws IOException {
        String searchUrl = CITE_URL + SEARCH_PREFIX + transformRequest(request);
        return Jsoup.parse(new URL(searchUrl), 1000);
    }

    private static String transformRequest(String request) {
        return request.trim().replaceAll(" ", "+");
    }

    public static ArrayList<FilmItem> getFilmItems(Document searchResultsPage, int itemsCount){
        Elements posterElements = searchResultsPage.select(POSTER_QUERY);
        Elements titleElements = searchResultsPage.select(TITLE_QUERY);

        if(itemsCount < 0 || itemsCount > posterElements.size())
            itemsCount = posterElements.size();

        String[] posterAddressArr = new String[itemsCount];

        for(int index = 0; index < itemsCount; index++){
            Element element = posterElements.get(index);
            String imgTag = element.select("img").toString();
            int beginIndex = imgTag.indexOf("src")+5;
            int endIndex = imgTag.indexOf(".jpg")+4;
            posterAddressArr[index] = imgTag.substring(beginIndex, endIndex);
            index++;
        }

        ArrayList<FilmItem> items = new ArrayList<FilmItem>(itemsCount);

        for(int index = 0; index < itemsCount; index++) {
            Element element = titleElements.get(index).select("a").first();
            String title = element.text();
            String aTag = element.toString();
            String link = aTag.substring(aTag.indexOf("/"), aTag.indexOf("-subtitles"));
            FilmItem filmItem = new FilmItem();
            filmItem.setTitle(title);
            filmItem.setPosterAddress(CITE_URL + posterAddressArr[index]);
            filmItem.setLink(CITE_URL + link + "/english-subtitles");
            items.add(filmItem);
        }

        return items;
    }

    public static ArrayList<FilmItem> getFilmItems(Document searchResultsPage){
//        if -1 then returns all items on the page
        return getFilmItems(searchResultsPage, -1);
    }

    //нужно качать html ручками потому что jsoup бросает исключение из-за редиректа на странице
    private static String getHTMLCode(String address) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            url = new URL(address);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String getSubtitlesAddress(FilmItem item) throws IOException {
        String address = item.getLink();
        Document page = Jsoup.parse(new URL(address), 1000);
        Element element = page.select("td[data-title=Download]").first().select("a").first();
        String downloadAddress = element.toString();
        int beginIndex = downloadAddress.indexOf("href")+6;
        int endIndex = downloadAddress.indexOf("\">");
        downloadAddress = downloadAddress.substring(beginIndex, endIndex);
        downloadAddress = CITE_URL + downloadAddress;
        downloadAddress = getHTMLCode(downloadAddress);
        beginIndex = downloadAddress.indexOf("href")+6;
        endIndex = downloadAddress.indexOf("zip")+3;
        downloadAddress = downloadAddress.substring(beginIndex, endIndex);
        return downloadAddress;
    }

    public static InputStream getSubtitlesInputStream(String subtitlesAddress){
        URLConnection connection;
        try {
            connection =  new URL(subtitlesAddress).openConnection();
            return connection.getInputStream();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String getSubtitlesString(FilmItem item){
        try {
            String subtitlesAddress = Parser.getSubtitlesAddress(item);
            InputStream subtitlesInputStream = Parser.getSubtitlesInputStream(subtitlesAddress);
            return getSubtitlesString(subtitlesInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String filterString(String str){
        return str.replaceAll("\\n", " ")
                .replaceAll("\\d", "")
                .replaceAll("[.,:?!-\"]", "")
                .replaceAll("]", "")
                .replaceAll("\\[", "");
    }

    public static String getSubtitlesString(InputStream inputZip){
        StringBuilder sb = new StringBuilder();
        try{
            ZipInputStream zis = new ZipInputStream(inputZip);
            BufferedReader reader = new BufferedReader(new InputStreamReader(zis));
            ZipEntry ze;

            for(ze = zis.getNextEntry(); ze != null; ze = zis.getNextEntry()){
                String fileName = ze.getName();
                if(fileName.equals(GARBAGE_FILE))
                    continue;

                String str;
                int counter = 2;
                while((str = reader.readLine()) != null) {
                    if(str.trim().equals("")) {
                        counter = 3;
                    }
                    if(counter > 0) {
                        counter--;
                        continue;
                    }
                    sb.append(str);
                    sb.append("\n");
                }
            }

            zis.closeEntry();
            zis.close();
            reader.close();

        }catch(IOException ex){
            ex.printStackTrace();
        }
        String result = sb.toString();
        return filterString(result);
    }
}
