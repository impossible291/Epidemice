package com.testgradution.testgradution;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class TestgradutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestgradutionApplication.class, args);

        //String strurl="https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5&callback";
        //建立url爬取核心对象
//        try {
//            URL url=new URL(strurl);
//            //通过url建立与网页的连接
//            URLConnection conn=url.openConnection();
//            //通过链接取得网页返回的数据
//            InputStream is=conn.getInputStream();
//            //一般按行读取网页数据，并进行内容分析
//            //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
//            //进行转换时，需要处理编码格式问题
//            BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));
//            String str=br.readLine();
//            //System.out.println(str);
//            //String s=str.substring(str.indexOf('(')+1,str.indexOf(')'));
//            //System.out.println(s);
//            JSONObject jsonObject= JSON.parseObject(str);
//            String s=String.valueOf(jsonObject.get("data"));
//            JSONObject jsonObject1=JSONObject.parseObject(s);
//            //System.out.println(jsonObject1);
//            String x=String.valueOf(jsonObject1.get("areaTree"));
//            JSONArray jsonArray=JSONArray.parseArray(x);
//            System.out.println(jsonArray);
//            for(int i =0;i<jsonArray.size();i++){
//                System.out.println(jsonArray.getJSONObject(i).getString("children"));
//            }
//          //  System.out.println(jsonObject2.get("children"));
//            //String s=jsonObject.getString("data");
////            JSONObject jsonObject1=JSONObject.parseObject(s);
////            System.out.println(jsonObject1);
//
//
//            //按行读取并打印
//            String line=null;
//            while((line=br.readLine())!=null){
//                System.out.println(line);
//            }
//
//            br.close();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }


}
