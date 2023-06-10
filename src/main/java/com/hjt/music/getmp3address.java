package com.hjt.music;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class getmp3address {

    //��װ����
    public static String mp3Url(String rid) throws Exception {
        //1.�����ַ
        String mp3SrcUrl = "http://m.kuwo.cn/newh5app/api/mobile/v1/music/src/"+rid;
        //2.ģ���������������
        URLConnection urlConn = new URL(mp3SrcUrl).openConnection();
        //3.��ȡ��
        InputStream in = urlConn.getInputStream();
        //4.���ֽ���ת��Ϊ�ַ�����ȡ
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //5.ֱ�Ӷ�ȡһ��
        String s = br.readLine();
        //6.һ��json
        String mp3Url = JSON.parseObject(s).getJSONObject("data").getString("url");
        //System.out.println(mp3Url);
        return mp3Url;
    }
    public static void main(String[] args) throws Exception {
        getmp3address.mp3Url("440615");
    }

}
