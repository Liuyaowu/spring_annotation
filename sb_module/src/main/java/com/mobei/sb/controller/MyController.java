package com.mobei.sb.controller;

import com.mobei.sb.bean.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {

    @Resource
    private Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

}
