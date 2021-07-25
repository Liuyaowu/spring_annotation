package com.mobei.sb.controller;

import com.mobei.sb.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 从配置文件读取值,如果为空则默认为default
     */
    @Value("${environment:default}")
    private String environment;

    @Autowired
    Person person;

    @GetMapping("/")
    public String hello() {
        return "当前环境: " + environment;
    }

    @GetMapping("/person")
    public Person person() {
        return person;
    }

}
