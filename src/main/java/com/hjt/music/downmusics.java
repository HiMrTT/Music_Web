package com.hjt.music;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class downmusics {

    //�������ַ�����װ
    public static void downloadMusic(String playUrl, String name) throws Exception{
        //1.�����ַ�������������ص�ַ
        //String playUrl = "https://sy-sycdn.kuwo.cn/26c55b11053729927c354bd2d135f15b/621ebaa2/resource/a2/34/65/1171635934.aac";
        //2.ģ���������������
        //2.1 ����һ��������Ϣ����
        //2.2 ͨ�����������Ϣ���������
        URLConnection urlConn = new URL(playUrl).openConnection();
        //2.3 ͨ�����ӻ�ȡ����
        InputStream in = urlConn.getInputStream();
        //3. ��Ҫд�ڵ�����
        //3.1 ���������
        FileOutputStream out = new FileOutputStream("D:\\"+name+".mp3");
        //3.2 ��ʼ����
        //1000000
        //����һ���ֽ����飬һ���Զ�ȡ1kb
        byte[] b = new byte[1024];
        //����һ���������洢ÿ�ζ�ȡ���ֽ���
        int len;
        //��ʼѭ������
        while((len = in.read(b)) != -1) {
            //����
            out.write(b, 0, len);
        }
        //ˢ��
        out.flush();
        //�ͷ�����Դ
        out.close();
        in.close();
        System.out.println(name+"-->���سɹ�������");
    }

    //���÷���
    public static void main(String[] args) throws Exception{
        //�������һ������
        //downmusics z = new downmusics();
        //���øո�д�ķ���
        String playUrl = "https://sy-sycdn.kuwo.cn/26c55b11053729927c354bd2d135f15b/621ebaa2/resource/a2/34/65/1171635934.aac";
        //��̬����
        downmusics.downloadMusic(playUrl, "����");
    }

}
