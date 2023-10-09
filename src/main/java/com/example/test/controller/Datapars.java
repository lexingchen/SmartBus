package com.example.test.controller;

import com.example.test.bean.S_data;
import com.example.test.mapper.DataMapper;
import com.example.test.service.DataService;
import com.example.test.tool.BeanContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

@Controller
public
class Datapars implements Runnable{
    //S001#44.00#23.00#1023#26.1154#177.3335
    private DataMapper dataMapper;
    @Override
    public void run() {
        try {
            ServerSocket ss  = new ServerSocket(8080);//创建一个serversocket其端口与发送端的端口是一样的
            Socket s = ss.accept();//侦听并接受到此套接字的连接，返回一个socket对象
            InputStream is = s.getInputStream();//获取到输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            byte[] buf = new byte[1024];//接收收到的数据
            int line = 0;
            while((line=is.read(buf))!=-1){
                String tempdata = new String(buf,0,line);
                String str = tempdata.replaceAll(" ","");//去空格
                //线程是安全的，线程中不能够直接注入bean
                dataMapper = BeanContext.getApplicationContext().getBean(DataMapper.class);
                //数据插入数据库
                if(tempdata.contains("#")){
                    System.out.println(str);
                    str = str.replaceAll("NAN","00");
                    String[] temp = str.split("#");
                    S_data s_datatemp = new S_data(0,"null",0,0,0,"00","00",null);
                    s_datatemp.setDevid(temp[0]);
                    s_datatemp.setHum(Float.parseFloat(temp[1]));
                    s_datatemp.setTem(Float.parseFloat(temp[2]));
                    s_datatemp.setRain(Integer.parseInt(temp[3]));
                    s_datatemp.setNorth(temp[4]);
                    s_datatemp.setEast(temp[5]);
                    java.util.Date date = new Date();//获得当前时间
                    Timestamp t = new Timestamp(date.getTime());//将时间转换成Timestamp类型，这样便可以存入到Mysql数据库中
                    s_datatemp.setDatatime(t);
                    Random r = new Random();
                    s_datatemp.setNorth(temp[4]+""+r.nextInt(111));
                    s_datatemp.setEast(temp[5]+""+r.nextInt(111));
                    System.out.println(s_datatemp.toString());
                    System.out.println(dataMapper.s_dataadd(s_datatemp));
                }

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}