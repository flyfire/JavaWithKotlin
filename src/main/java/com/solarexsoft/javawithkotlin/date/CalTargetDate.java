package com.solarexsoft.javawithkotlin.date;

import java.util.Calendar;

/*
 * Created by Solarex on 2024/05/17 14:52
 */
public class CalTargetDate {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.YEAR, 9);
        calendar.add(Calendar.MONTH, 4);
        System.out.println(calendar.getTime());
    }
}
