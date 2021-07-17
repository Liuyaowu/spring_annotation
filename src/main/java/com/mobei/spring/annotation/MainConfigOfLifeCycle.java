package com.mobei.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期: 创建--初始化--销毁
 *
 * 可以自定义初始化和销毁的方法: 容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 1、指定初始化和销毁方法: @Bean指定initMethod和destroyMethod
 * 2、让Bean实现InitializingBean(定义初始化逻辑)和DisposableBean(定义销毁逻辑)
 *
 */
@ComponentScan("com.mobei.spring.bean")
@Configuration
public class MainConfigOfLifeCycle {

//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public Car car() {
//        return new Car();
//    }

}
