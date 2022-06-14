package com.sparta.wl.week5.star_war;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}Z";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("2014-12-09T13:50:51.644000Z");
        System.out.println(m.matches());
    }
}
