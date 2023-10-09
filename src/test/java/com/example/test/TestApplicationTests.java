package com.example.test;

import com.example.test.bean.S_data;
import com.example.test.mapper.DataMapper;
import com.example.test.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    DataMapper dataMapper;
    @Autowired
    DataService dataService;
    @Test
    void contextLoads() {
        System.out.println(dataMapper.datalist3().toString());
    }

    @Test
    void datashow() {
        System.out.println(dataMapper.datashow().toString());
        System.out.println(dataService.datashow().toString());
        //S_data{id=166, devid='S002', hum=44.0, tem=23.0, rain=1023, north='26.1154', east='177.3335', datatime=Thu Jun 22 12:31:34 CST 2023}]
        //S_data{id=0, devid='S002', hum=44.0, tem=23.0, rain=1023, north='26.1154', east='177.3335', datatime=2023-06-22 12:45:55.498}
        //S_data{id=167, devid='S002', hum=44.0, tem=23.0, rain=1023, north='26.1154', east='177.3335', datatime=Thu Jun 22 12:45:55 CST 2023}
    }

    @Test
    void addtest() {
        String ss = "S001#NAN#NAN#1023#26.1154#177.3335";
        ss = ss.replaceAll("NAN","00");
        System.out.println(ss);
        String[] temp = ss.split("#");
        S_data s_datatemp = new S_data();
        s_datatemp.setDevid(temp[0]);
        s_datatemp.setHum(Float.parseFloat(temp[1]));
        s_datatemp.setTem(Float.parseFloat(temp[2]));
        s_datatemp.setRain(Integer.parseInt(temp[3]));
        s_datatemp.setNorth(temp[4]);
        s_datatemp.setEast(temp[5]);
        Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());//将时间转换成Timestamp类型，这样便可以存入到Mysql数据库中
        s_datatemp.setDatatime(t);
        System.out.println(dataService.s_datdadd(s_datatemp));
        System.out.println(s_datatemp.toString());
    }



}
