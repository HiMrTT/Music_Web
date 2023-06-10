package com.hjt.music;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class jsonpoke {

    public static void main(String[] args) {

        //JSON格式：{}
        //手动创建一个JSON数据：
        //存储我的个人信息：{"name":"刘盼民", "sex":"男", "age":18}
        String json1 = "{\"name\":\"刘盼民\", \"sex\":\"男\", \"age\":18}";
        //使用json工具转化为json对象
        JSONObject jsonObject1 = JSON.parseObject(json1);
        String sex = jsonObject1.getString("sex");
        System.out.println(sex);
        //取age
//        int age = jsonObject1.getIntValue("age");
//        System.out.println(age);
        //1.保存字符串
        String json2 = "{\"success\":true,\"code\":200,\"data\":{\"id\":\"228908\",\"url\":\"https://sy-sycdn.kuwo.cn/d8374a6e6745ca93ebb968fbb7e6e22d/621ed206/resource/a2/34/65/1171635934.aac\",\"duration\":269}}";
        //2.将字符串转化为json对象
        JSONObject jsonObject2 = JSON.parseObject(json2);
        //3.取
        String success = jsonObject2.getString("success");
        System.out.println(success);
        String code = jsonObject2.getString("code");
        System.out.println(code);
        //4.取data
//        String data = jsonObject2.getString("data");
//        System.out.println(data);
        JSONObject dataJson = jsonObject2.getJSONObject("data");
        String url = dataJson.getString("url");
        System.out.println("url="+url);
    }

}
