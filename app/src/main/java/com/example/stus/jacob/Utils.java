package com.example.stus.jacob;

import java.util.Random;

/**
 * Created by stus on 14.05.17.
 */

public class Utils {
    public static String getRandomId(int lenght) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            builder.append(new Random().nextInt(9));
        }
        return builder.toString();
    }
}
