package com.hjt.music;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class downmusics {

    //下载音乐方法封装
    public static void downloadMusic(String playUrl, String name) throws Exception{
        //1.变量字符串保存歌曲下载地址
        //String playUrl = "https://sy-sycdn.kuwo.cn/26c55b11053729927c354bd2d135f15b/621ebaa2/resource/a2/34/65/1171635934.aac";
        //2.模拟浏览器发送请求
        //2.1 创建一个连接信息对象
        //2.2 通过这个连接信息对象打开连接
        URLConnection urlConn = new URL(playUrl).openConnection();
        //2.3 通过连接获取数据
        InputStream in = urlConn.getInputStream();
        //3. 需要写在电脑上
        //3.1 创建输出流
        FileOutputStream out = new FileOutputStream("D:\\"+name+".mp3");
        //3.2 开始复制
        //1000000
        //创建一个字节数组，一次性读取1kb
        byte[] b = new byte[1024];
        //创建一个整数，存储每次读取的字节数
        int len;
        //开始循环复制
        while((len = in.read(b)) != -1) {
            //复制
            out.write(b, 0, len);
        }
        //刷新
        out.flush();
        //释放流资源
        out.close();
        in.close();
        System.out.println(name+"-->下载成功！！！");
    }

    //调用方法
    public static void main(String[] args) throws Exception{
        //创建类的一个对象
        //downmusics z = new downmusics();
        //调用刚刚写的方法
        String playUrl = "https://sy-sycdn.kuwo.cn/26c55b11053729927c354bd2d135f15b/621ebaa2/resource/a2/34/65/1171635934.aac";
        //动态传参
        downmusics.downloadMusic(playUrl, "晴天");
    }

}
