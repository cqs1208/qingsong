package com.qingsong.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author : chenqingsong
 * @date : 2019-12-23 16:35
 */
@RestController
public class TestController {

    @Autowired
    StringEncryptor stringEncryptor;//密码解码器自动注入

    @Value("${spring.datasource.password}")
    private String password;


    @RequestMapping(value="/test", method= RequestMethod.POST)
    @ResponseBody
    public String rsaTest() {
        return  "test";
    }

    @RequestMapping(value="/test2", method= RequestMethod.POST)
    @ResponseBody
    public void test() {
        System.out.println("连接数据库密码:" + password);
    }
}
