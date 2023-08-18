package com.solarexsoft.javawithkotlin.file;

import java.io.File;

/*
 * Created by Solarex on 2023/02/20 15:22
 */
public class FileWithLrc {
    public static void main(String[] args) {
        String path = "/sdcard/mp3/aaaa.mp3";
        File file = new File(path);
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
