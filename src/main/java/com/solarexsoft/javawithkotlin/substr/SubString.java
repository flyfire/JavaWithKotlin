package com.solarexsoft.javawithkotlin.substr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/*
 * Created by Solarex on 2023/03/06 17:27
 */
public class SubString {
    public static void main(String[] args) {
        String path = "https://source.listeneer.com/%E6%9C%AC%E5%9C%B0%E5%8C%96%E8%B5%84%E6%BA%90/%E4%B9%A6%E7%B1%8D/%E5%88%86%E7%BA%A7%E9%98%85%E8%AF%BB/%E9%A2%84%E5%A4%873-6%E5%B2%81/Hello%20Andy%E8%8B%B1%E8%AF%AD%E5%90%AF%E8%92%99%E7%B3%BB%E5%88%97%20%E7%AC%AC%E4%BA%8C%E8%BE%91/Hello%20Andy%E7%AC%AC%E4%BA%8C%E8%BE%91%20%E9%98%85%E8%AF%BB%E7%89%88/8.My%20Cap.lis";
//        path = "https:%2F%2Fsource.listeneer.com%2F%25E6%259C%25AC%25E5%259C%25B0%25E5%258C%2596%25E8%25B5%2584%25E6%25BA%2590%2F%25E4%25B9%25A6%25E7%25B1%258D%2F%25E5%2588%2586%25E7%25BA%25A7%25E9%2598%2585%25E8%25AF%25BB%2F%25E9%25A2%2584%25E5%25A4%25873-6%25E5%25B2%2581%2FHello%2520Andy%25E8%258B%25B1%25E8%25AF%25AD%25E5%2590%25AF%25E8%2592%2599%25E7%25B3%25BB%25E5%2588%2597%2520%25E7%25AC%25AC%25E4%25BA%258C%25E8%25BE%2591%2FHelloAndy%25E7%25AC%25AC%25E4%25BA%258C%25E8%25BE%2591%2520%25E8%25A7%2586%25E9%25A2%2591%2Fopen%2520the%2520door.mp4";
        path = "https://source.listeneer.com/%E8%BE%BE%E4%BA%BA%E8%B5%84%E6%BA%90%E5%85%A5%E5%8F%A3%2F%E5%90%8E%E7%AB%AF%E6%B5%8B%E8%AF%95%2F%E6%98%AF%E6%98%AF%E6%98%AF%2F%E9%9F%B3%E9%A2%91%E5%90%84%E7%B1%BB%E6%96%87%E4%BB%B6%E5%A4%A7%E5%B0%8F%E5%86%99%2F%E9%9F%B3%E9%A2%91%E5%90%84%E7%B1%BB%E6%96%87%E4%BB%B6%E5%A4%A7%E5%B0%8F%E5%86%99%2FMP3%2Foriginal%2FWithin%20Temptation%20-%20Shot%20In%20The%20Dark%20%28Radio%20Edit%29.mp3";
        path = "https://source.listeneer.com/%2F%E6%9C%AC%E5%9C%B0%E5%8C%96%E8%B5%84%E6%BA%90%2F%E4%B9%A6%E7%B1%8D%2F%E5%88%86%E7%BA%A7%E9%98%85%E8%AF%BB%2F%E9%A2%84%E5%A4%873-6%E5%B2%81%2FHello%20Andy%E8%8B%B1%E8%AF%AD%E5%90%AF%E8%92%99%E7%B3%BB%E5%88%97%20%E7%AC%AC%E4%BA%8C%E8%BE%91%2FHelloAndy%E7%AC%AC%E4%BA%8C%E8%BE%91%20%E8%A7%86%E9%A2%91%2Fopen%20the%20door.mp4";
        path = "https://source.listeneer.com/%2F%E6%9C%AC%E5%9C%B0%E5%8C%96%E8%B5%84%E6%BA%90%2F%E5%88%86%E7%B1%BB%E5%9B%BE%E7%89%87%2F%E5%88%86%E7%BA%A7%E9%98%85%E8%AF%BB%2F%E9%A2%84%E5%A4%873-6%E5%B2%81%2FHello%20Andy%E8%8B%B1%E8%AF%AD%E5%90%AF%E8%92%99%E7%B3%BB%E5%88%97%20%E7%AC%AC%E4%BA%8C%E8%BE%91.png";
        path = "https://source.listeneer.com/%E8%BE%BE%E4%BA%BA%E8%B5%84%E6%BA%90%E5%85%A5%E5%8F%A3%2F%E5%90%8E%E7%AB%AF%E6%B5%8B%E8%AF%95%2Foriginal%2F%E7%A7%BB%E5%8A%A8%E7%9B%AE%E5%BD%95%2F%E7%A7%BB%E5%8A%A8%E7%9B%AE%E5%BD%95%2F%E9%9F%B3%E9%A2%91%E5%90%84%E7%B1%BB%E6%96%87%E4%BB%B6%E5%A4%A7%E5%B0%8F%E5%86%99%2F%E6%8E%92%E5%BA%8F%2F1%E7%90%AA+-+%E7%81%B0%E5%A7%91%E5%A8%98.ape+-+%E5%89%AF%E6%9C%AC.mp3";
        path = "中文";
        path = "https://source.listeneer.com//本地化资源/书籍/分级阅读/预备3-6岁/Hello Andy英语启蒙系列 第二辑/HelloAndy第二辑 视频/open the door.mp4";
//        try {
//            String encode = URLEncoder.encode(path, "UTF-8");
//            System.out.println(encode);
//            String decode = URLDecoder.decode(encode, "UTF-8");
//            FileOutputStream fos = new FileOutputStream(new File("aaa.txt"));
//            System.out.println(decode);
//            fos.write(decode.getBytes(StandardCharsets.UTF_8));
//            fos.flush();
//            fos.close();
//            System.out.println("中文");
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
        String[] split = path.split("/");
        for (String tmp : split) {
            System.out.println(tmp);
        }
    }



}
