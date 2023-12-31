package com.hjt.music;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class getmp3address {

    //封装方法
    public static String mp3Url(String rid) throws Exception {
        //1.保存地址
        String mp3SrcUrl = "http://m.kuwo.cn/newh5app/api/mobile/v1/music/src/"+rid;
        //2.模拟浏览器发送请求
        URLConnection urlConn = new URL(mp3SrcUrl).openConnection();
        //3.获取流
        InputStream in = urlConn.getInputStream();
        //4.将字节流转化为字符流读取
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //5.直接读取一行
        String s = br.readLine();
        //6.一段json
        String mp3Url = JSON.parseObject(s).getJSONObject("data").getString("url");
        //System.out.println(mp3Url);
        return mp3Url;
    }
    public static void main(String[] args) throws Exception {
        getmp3address.mp3Url("440615");
    }

}
