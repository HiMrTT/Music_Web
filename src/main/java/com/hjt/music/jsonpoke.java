package com.hjt.music;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class jsonpoke {

    public static void main(String[] args) {

        //JSON��ʽ��{}
        //�ֶ�����һ��JSON���ݣ�
        //�洢�ҵĸ�����Ϣ��{"name":"������", "sex":"��", "age":18}
        String json1 = "{\"name\":\"������\", \"sex\":\"��\", \"age\":18}";
        //ʹ��json����ת��Ϊjson����
        JSONObject jsonObject1 = JSON.parseObject(json1);
        String sex = jsonObject1.getString("sex");
        System.out.println(sex);
        //ȡage
//        int age = jsonObject1.getIntValue("age");
//        System.out.println(age);
        //1.�����ַ���
        String json2 = "{\"success\":true,\"code\":200,\"data\":{\"id\":\"228908\",\"url\":\"https://sy-sycdn.kuwo.cn/d8374a6e6745ca93ebb968fbb7e6e22d/621ed206/resource/a2/34/65/1171635934.aac\",\"duration\":269}}";
        //2.���ַ���ת��Ϊjson����
        JSONObject jsonObject2 = JSON.parseObject(json2);
        //3.ȡ
        String success = jsonObject2.getString("success");
        System.out.println(success);
        String code = jsonObject2.getString("code");
        System.out.println(code);
        //4.ȡdata
//        String data = jsonObject2.getString("data");
//        System.out.println(data);
        JSONObject dataJson = jsonObject2.getJSONObject("data");
        String url = dataJson.getString("url");
        System.out.println("url="+url);
    }

}
