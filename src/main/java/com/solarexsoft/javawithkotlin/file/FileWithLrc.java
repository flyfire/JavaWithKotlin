package com.solarexsoft.javawithkotlin.file;

import java.io.File;

/*
 * Created by Solarex on 2023/02/20 15:22
 */
public class FileWithLrc {
    public static void main(String[] args) {
        String path = "/sdcard/mp3/aaaa.mp3";
//        String path = "/sdcard/专属资源/球妈共学营/｜7课外听力｜/课外教材/Power Up/Level 2/aaa.mp3";
        File file = new File(path);
        try {
            String s = file.getCanonicalPath();
            System.out.println("path = " + s);
        } catch (Throwable throwable) {
            System.out.println("invalid path: " + throwable.getLocalizedMessage());
        }
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
        int index = path.lastIndexOf("/");
        String nameWithExtension = path.substring(index + 1);
        System.out.println(nameWithExtension);
        int dotIndex = nameWithExtension.lastIndexOf(".");
        String name = nameWithExtension.substring(0, dotIndex);
        System.out.println(name);
        File lrcFile = new File(parentFile, name + ".lrc");
        System.out.println(lrcFile);
    }
}
