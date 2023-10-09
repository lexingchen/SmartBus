package com.example.test.controller;

import com.example.test.bean.S_data;
import com.example.test.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.util.List;


@Controller
public class DataController {
    @Autowired
    DataService dataService;

    @RequestMapping("/UNO")
    public String UNOR3(){
//        new Thread(new Datapars()).start();//先开启接收端的线程
        return "index";
    }

    @RequestMapping("/index")
    public String indexshow(HttpSession Session){
        S_data s_data = dataService.datashow();
        Session.setAttribute("datashow",s_data);
        return "index";
    }
    @RequestMapping("/bus")
    public String busshow(HttpSession Session){
        return "bus";
    }
    @RequestMapping("/station")
    public String stationshow(HttpSession Session){

        return "station";
    }
    @RequestMapping("/user")
    public String usershow(HttpSession Session){

        return "user";
    }
    @RequestMapping("/showdata")
    public ModelAndView datashow(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        List<S_data> list = dataService.datalist3();
        modelAndView.addObject("datalist3", list);
        modelAndView.setViewName("showdata");
        return modelAndView;
    }
    @RequestMapping("Daa")
    public @ResponseBody
    S_data findUser()throws Exception {
        return dataService.datashow();
    }




}
