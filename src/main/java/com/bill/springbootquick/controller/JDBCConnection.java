package com.bill.springbootquick.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class JDBCConnection {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @ResponseBody
    @GetMapping("/jdbc/id={depid}")
    public Map<String,Object> jdbc(@PathVariable("depid") Integer depid, Map<String,Object> map){
        try {
            List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from department where id="+depid);
            return list.get(0);
        }catch (Exception e){
            System.err.println("抓到的List是空的and  "+e.getMessage());
            map.put("db","null");
            return  map;
        }

    }



}