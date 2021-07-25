package com.mobei.sb.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyAppContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("MyAppContextInitializer 的 initialize 方法执行了");
    }

}
