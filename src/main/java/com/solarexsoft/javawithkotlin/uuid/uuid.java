package com.solarexsoft.javawithkotlin.uuid;

import java.util.UUID;

/*
 * Created by Solarex on 2023/02/23 20:42
 */
public class uuid {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        int length = uuid.length();
        System.out.println(uuid);
        System.out.println("" + length);
    }
}
