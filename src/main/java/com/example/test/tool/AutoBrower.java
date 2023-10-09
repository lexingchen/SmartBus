package com.example.test.tool;


import com.example.test.controller.Datapars;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@Configuration
public class AutoBrower {//项目自启动，进程启动处
    @EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {
        System.out.println("数据服务器启动......");
        new Thread(new Datapars()).start();//先开启接收端的线程
        // 这里需要注url:端口号+测试类方法名
        System.out.print("页面加载成功：");
        String url = "http://localhost:8081/index";
        System.out.println(url);
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}