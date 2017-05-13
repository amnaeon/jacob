package com.example.stus.jacob.subtitlesLogic;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anatoly on 08.05.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter film name: ");
//        String filmName = sc.next();
        String filmName = "watchmen";
        Document page = Parser.getSearchResults(filmName);
        ArrayList<FilmItem> items = Parser.getFilmItems(page, 5);

        for(FilmItem item : items)
            System.out.println(item);

        String bigStr = Parser.getSubtitlesString(items.get(0));

        System.out.println(bigStr);
    }
}
