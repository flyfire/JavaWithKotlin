package com.solarexsoft.javawithkotlin.regex;

/*
 * Created by Solarex on 2024/05/09 16:39
 */
public class TopDomain {
    public static String topLevelDomain(String host) {
        int lastIndex = host.lastIndexOf(".");
        if (lastIndex <= 0) {
            return host;
        }
        int secondLastIndex = host.lastIndexOf(".", lastIndex - 1);
        if (secondLastIndex < 0) {
            return host;
        } else {
            return host.substring(secondLastIndex + 1);
        }
    }

    public static void main(String[] args) {
        String[] domainArray = new String[]{"example1.com", "sub.example2.com"};
        for (String s : domainArray) {
            System.out.println(s + " = " + topLevelDomain(s));
        }
    }
}
