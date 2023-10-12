package com.solarexsoft.javawithkotlin.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
 * Created by Solarex on 2023/09/07 14:38
 */
public class GetPath {
    private static volatile int reqId = 0;
    public static void main(String[] args) {
        try {
            String decoded = URLDecoder.decode("http://yt-audio-file.oss-cn-shenzhen.aliyuncs.com/%E5%A4%A7%E5%B0%8F%E5%A8%83-%E9%97%AE%E7%AD%94%2Fvoice%2F1693551692841.ogg?Expires=1693551992&OSSAccessKeyId=LTAI5t9VyvhUZstfHodRksqs&Signature=LD4apa9t6GcmLJ%2FkH98%2FmAqnvww%3D");
            URL url = new URL(decoded);
            String path = url.getPath();
            System.out.println(path);
            reqId++;
            new Thread(new ReqIdRunnable(reqId, new IListener() {
                @Override
                public void onReqId(int i) {
                    System.out.println("i = " + i + ", reqId = " + reqId);
                }
            })).start();
            reqId++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException exception) {

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static class ReqIdRunnable implements Runnable {
        private final int reqId;
        private final IListener listener;

        public ReqIdRunnable(int reqId, IListener listener) {
            this.reqId = reqId;
            this.listener = listener;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {

            }
            if (listener != null) {
                listener.onReqId(reqId);
            }
        }
    }

    public interface IListener {
        void onReqId(int reqId);
    }
}
