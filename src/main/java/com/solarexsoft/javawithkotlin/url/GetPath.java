package com.solarexsoft.javawithkotlin.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
 * Created by Solarex on 2023/09/07 14:38
 */
public class GetPath {
    public static void main(String[] args) {
        try {
            String decoded = URLDecoder.decode("http://yt-audio-file.oss-cn-shenzhen.aliyuncs.com/%E5%A4%A7%E5%B0%8F%E5%A8%83-%E9%97%AE%E7%AD%94%2Fvoice%2F1693551692841.ogg?Expires=1693551992&OSSAccessKeyId=LTAI5t9VyvhUZstfHodRksqs&Signature=LD4apa9t6GcmLJ%2FkH98%2FmAqnvww%3D");
            URL url = new URL(decoded);
            String path = url.getPath();
            System.out.println(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
