package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController  //此类的所有方法都返回字符串
@Controller
public class UserController {
//    @RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
    //@ResponseBody  //不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User(1,"titor",20);
        String str = mapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<>();

        User user1 = new User(1,"titor1",21);
        User user2 = new User(2,"titor2",22);
        User user3 = new User(3,"titor3",23);
        User user4 = new User(4,"titor4",24);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = mapper.writeValueAsString(userList);

        return str;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //使用ObjectMapper来格式化输出
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mapper.setDateFormat(sdf);

        Date date = new Date();

        //默认格式为timestamp时间戳
        return mapper.writeValueAsString(date);
    }
}
