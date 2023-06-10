package com.hjt.music;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

public class musictest {

    public static void main(String[] args) throws Exception{
        //手动输入歌手，然后默认下载第一页所有数据
        Scanner s = new Scanner(System.in);
        System.out.print("请输入歌手：");
        String artist = s.nextLine();//歌手
        String musicData = getmusicdata.musicData(artist, "1");
        //解析
        JSONArray data = JSON.parseObject(musicData).getJSONArray("data");
        //循环遍历
        for (int i = 0; i < data.size(); i++) {
            JSONObject music = data.getJSONObject(i);
            //获取歌名
            String name = music.getString("name");
            //获取歌手
            String artist_name = music.getString("artist_name");
            //获取id
            String id = music.getString("id");
            //需要下载
            //先通过id获取下载的地址
            String mp3Url = getmp3address.mp3Url(id);
            //通过url下载
            downmusics.downloadMusic(mp3Url, artist_name + " - " + name);
        }
    }

}
