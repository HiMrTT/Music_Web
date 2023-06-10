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

    //����
    public static String musicData(String artist, String pn) throws Exception{
        //������ת��Ϊurl����
        artist = URLEncoder.encode(artist, "UTF-8");

        //1.�����ַ
        String musicDataUrl = "http://m.kuwo.cn/newh5app/api/mobile/v1/search/music?key="+artist+"&pn="+pn;
        //2.ģ���������������
        URLConnection urlConn = new URL(musicDataUrl).openConnection();
        //3.��ȡ��
        InputStream in = urlConn.getInputStream();
        //4.���ֽ���ת��Ϊ�ַ�����ȡ
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        //5.ֱ�Ӷ�ȡһ��
        String s = br.readLine();
        //System.out.println(s);//��ӡ
        return s;
    }

    public static void main(String[] args) throws Exception {
        String s = getmusicdata.musicData("�ֿ���", "1");
        //ת��json����
        JSONObject jsonObject = JSON.parseObject(s);
        //��ȡjson����
        JSONArray data = jsonObject.getJSONArray("data");
        //ѭ������
        for (int i = 0; i < data.size(); i++) {
            JSONObject music = data.getJSONObject(i);
            //��ȡ����
            String name = music.getString("name");
            //��ȡ����
            String artist_name = music.getString("artist_name");
            //��ȡid
            String id = music.getString("id");
            System.out.println("����="+name);
            System.out.println("����="+artist_name);
            System.out.println("id="+id);
            System.out.println("=============================");
        }

    }
}
