package com.hjt.music;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

public class musictest {

    public static void main(String[] args) throws Exception{
        //�ֶ�������֣�Ȼ��Ĭ�����ص�һҳ��������
        Scanner s = new Scanner(System.in);
        System.out.print("��������֣�");
        String artist = s.nextLine();//����
        String musicData = getmusicdata.musicData(artist, "1");
        //����
        JSONArray data = JSON.parseObject(musicData).getJSONArray("data");
        //ѭ������
        for (int i = 0; i < data.size(); i++) {
            JSONObject music = data.getJSONObject(i);
            //��ȡ����
            String name = music.getString("name");
            //��ȡ����
            String artist_name = music.getString("artist_name");
            //��ȡid
            String id = music.getString("id");
            //��Ҫ����
            //��ͨ��id��ȡ���صĵ�ַ
            String mp3Url = getmp3address.mp3Url(id);
            //ͨ��url����
            downmusics.downloadMusic(mp3Url, artist_name + " - " + name);
        }
    }

}
