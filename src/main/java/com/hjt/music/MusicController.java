package com.hjt.music;

import com.alibaba.fastjson.JSON;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@RestController
@RequestMapping("/")
public class MusicController {
    @RequestMapping("/index")
    public String index(){
        return "Hello SpringBoot,你好";
    }
    @RequestMapping("/getmusicdata")
    public String getmusicdata(String key,String pn)throws Exception{
        String musicdata = getmusicdata.musicData(key, pn);

        return JSON.parseObject(musicdata).getString("data");
    }
    @RequestMapping("/mp3Url")
    public String mp3Url(String rid)throws Exception{
        String mp3Url = getmp3address.mp3Url(rid);
        return mp3Url;
    }
    @RequestMapping("/lrc")
    public String lrc(String rid)throws Exception{
        String lrc = getmusicword.lrc(rid);
        return lrc;
    }
    @RequestMapping("/pic")
    public String pic(String rid)throws Exception{
        String pic = getmusicface.pic(rid);
        return pic;
    }
    @RequestMapping("/download")
    public void download(String rid,String name,String artist_name,HttpServletResponse response)throws Exception{
        //1.需要拿到下载地址
        String mp3Url = getmp3address.mp3Url(rid);
        //2.使用流进行解析
        URLConnection urlConn = new URL(mp3Url).openConnection();
        InputStream in = urlConn.getInputStream();
        //3.将这个流数据写在浏览器上去
        //页面响应输出流
        //制定一个附件名称
        response.setCharacterEncoding("utf-8");
        String filename = URLEncoder.encode(artist_name + name, "UTF-8") + ".mp3";
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        ServletOutputStream out = response.getOutputStream();
        //4.开始写入到页面
        int len;
        byte[] b = new byte[1024];
        while((len = in.read(b)) != -1){
            //字节写入到电脑上
            out.write(b, 0, len);
        }
        out.flush();in.close();out.close();response.flushBuffer();
    }
}
