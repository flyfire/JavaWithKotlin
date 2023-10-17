package com.solarexsoft.javawithkotlin.regex;

/*
 * Created by Solarex on 2023/10/16 14:04
 */
public class TestNumberRangeV2 {
    public static void main(String[] args) {
        String sn = "HFKCLA2500001";
        boolean b = isValidSN(sn);
        System.out.println(sn + " --> " + b);
        sn = "aaaaaa1234567";
        b = isValidSN(sn);
        System.out.println(sn + " --> " + b);
        sn = "HFKCLA2500000";
        b = isValidSN(sn);
        System.out.println(sn + " --> " + b);
        sn = "HFKCLAaaaaaaa";
        b = isValidSN(sn);
        System.out.println(sn + " --> " + b);
        int start = 0;
        int end = 20200;

        for (int i = start; i <= end; i++) {
            String formattedNumber = String.format("%05d", i);
            String str = "HFKCLA25" + formattedNumber;
            boolean bb = isValidSN(str);
            if (!bb) {
                System.out.println("****** " + str + "  *******");
            }
        }
    }

    public static boolean isValidSN(String sn) {
        int length = sn.length();
        boolean startsWith = sn.startsWith("HFKCLA");
        if (!startsWith || length != 13) {
            return false;
        }
        String subStr = sn.substring(6);
//        System.out.println(subStr);
        try {
            int i = Integer.parseInt(subStr);
            if (2500001 <= i && i <= 2520200) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable throwable) {
            System.out.println("exception: " + throwable.getLocalizedMessage());
            return false;
        }
    }
}
