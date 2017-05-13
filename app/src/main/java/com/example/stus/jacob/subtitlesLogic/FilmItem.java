package com.example.stus.jacob.subtitlesLogic;

/**
 * Created by anatoly on 08.05.17.
 */
public class FilmItem {
    private String title;
    private String posterAddress;
    private String link;

    public FilmItem(String title, String posterAddress, String link) {
        this.title = title;
        this.posterAddress = posterAddress;
        this.link = link;
    }

    public FilmItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterAddress() {
        return posterAddress;
    }

    public void setPosterAddress(String posterAddress) {
        this.posterAddress = posterAddress;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "FilmItem{" +
                "title='" + title + '\'' +
                ", posterAddress='" + posterAddress + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
