package com.solarexsoft.javawithkotlin.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Created by Solarex on 2023/10/16 11:47
 */
public class TestNumberRange {
    public static void main(String[] args) {
        String pattern = "HFKCLA25([0-1]\\d\\d\\d\\d(?!0)|200\\d\\d|201\\d\\d|20200)";
        Pattern p = Pattern.compile(pattern);
        int start = 0;
        int end = 20200;

        for (int i = start; i <= end; i++) {
            String formattedNumber = String.format("%05d", i);
//            System.out.println(formattedNumber);
            String str = "HFKCLA25" + formattedNumber;
            Matcher matcher = p.matcher(str);
            boolean matches = matcher.matches();
            System.out.println(str + "   " + matches);
            if (!matches) {
                System.out.println("*****" + str);
            }
        }
        System.out.println("**********************");
    }
}
