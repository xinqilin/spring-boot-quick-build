package com.bill.springbootquick.controller;

import com.bill.springbootquick.exception.UserNotFindException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class hellocontroller {

    @ResponseBody
    @RequestMapping("/sayhello")
    public String sayHello(@RequestParam("user") String user) {
        if (user.equals("aaa")){
            throw  new UserNotFindException();
        }
        return "I say Hello";
    }

    @RequestMapping("/MVC")
    public String testMVC(Map<String, Object> map) {
        map.put("success1", "<h1>成功1</h1>");
        map.put("success", "<h1>成功</h1>");
        map.put("user", Arrays.asList("a","b","c"));

//        System.out.println(map.get("success1"));
        return "hello";
    }

}
