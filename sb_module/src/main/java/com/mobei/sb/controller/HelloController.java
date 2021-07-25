package com.mobei.sb.controller;

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

    @GetMapping("/")
    public String hello() {
        return "当前环境: " + environment;
    }

}
