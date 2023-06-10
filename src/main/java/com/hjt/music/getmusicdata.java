package com.hjt.music;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class getmusicdata {

    //方法
    public static String musicData(String artist, String pn) throws Exception{
        //将中文转化为url编码
        artist = URLEncoder.encode(artist, "UTF-8");

        //1.保存地址
        String musicDataUrl = "http://m.kuwo.cn/newh5app/api/mobile/v1/search/music?key="+artist+"&pn="+pn;
        //2.模拟浏览器发送请求
        URLConnection urlConn = new URL(musicDataUrl).openConnection();
        //3.获取流
        InputStream in = urlConn.getInputStream();
        //4.将字节流转化为字符流读取
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        //5.直接读取一行
        String s = br.readLine();
        //System.out.println(s);//打印
        return s;
    }

    public static void main(String[] args) throws Exception {
        String s = getmusicdata.musicData("林俊杰", "1");
        //转化json对象
        JSONObject jsonObject = JSON.parseObject(s);
        //获取json数组
        JSONArray data = jsonObject.getJSONArray("data");
        //循环遍历
        for (int i = 0; i < data.size(); i++) {
            JSONObject music = data.getJSONObject(i);
            //获取歌名
            String name = music.getString("name");
            //获取歌手
            String artist_name = music.getString("artist_name");
            //获取id
            String id = music.getString("id");
            System.out.println("歌名="+name);
            System.out.println("歌手="+artist_name);
            System.out.println("id="+id);
            System.out.println("=============================");
        }

    }
}
