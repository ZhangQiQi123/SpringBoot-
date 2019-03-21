package com.zqq.mall_web;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.zqq.bean.Response;

/**
 * 微服务调用方式
 * 服务提供的是什么服务，1.reset(http),2.web service,3.rpc
 * 1.reset RestTemplate或httpClient
 *
 */
public class App 
{
//	static String BASE_URL="http://127.0.0.1:8080";
//    public static void main( String[] args ) throws Exception
//    {
//        RestTemplate rt=new RestTemplate();
//        String body= rt.getForObject(BASE_URL+"/soa/product/6", String.class);
//        System.out.println(body);
//        Response response=new Gson().fromJson(body, Response.class);
//        System.out.println(response.getCode());
//        System.out.println(response.getMsg());
//        System.out.println(response.getData());
//    }
} 
