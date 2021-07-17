package com.mobei.spring.annotation;

import com.mobei.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期: 创建--初始化--销毁
 *
 * 可以自定义初始化和销毁的方法: 容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 1、指定初始化和销毁方法: 指定init-method和destroy-method
 *
 *
 */
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

}
