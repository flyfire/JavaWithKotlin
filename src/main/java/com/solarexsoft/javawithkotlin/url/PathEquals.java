package com.solarexsoft.javawithkotlin.url;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * Created by Solarex on 2023/12/25 16:21
 */
public class PathEquals {
    public static void main(String[] args) {
        try {
            boolean b = isPathEquals(
                    "https://hwavc.clewm.net/53e5ba2edf894c5a4d59ddddab5d7e50.mp3?auth_key=4ea428e21f5a734424099937195cd374&timestamp=1703487643",
                    "https://hwavc.clewm.net/53e5ba2edf894c5a4d59ddddab5d7e50.mp3?auth_key=811cc6c35aea8ba4240280fac781f60d&timestamp=1703487789"
            );
            System.out.println("pathEquals = " + b);
        } catch (Exception e) {

        }
    }

    private static boolean isPathEquals(String url1, String url2) throws MalformedURLException {
        URL newUrl1 = new URL(url1);
        URL newUrl2 = new URL(url2);
        String path1 = newUrl1.getPath();
        String path2 = newUrl2.getPath();
        System.out.println(path1);
        System.out.println(path2);
        String host1 = newUrl1.getHost();
        String host2 = newUrl2.getHost();
        System.out.println(host1);
        System.out.println(host2);
        return path1.equals(path2) && host1.equals(host2);
    }
}
