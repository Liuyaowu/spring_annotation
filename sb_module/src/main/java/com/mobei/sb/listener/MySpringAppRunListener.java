package com.mobei.sb.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringAppRunListener implements SpringApplicationRunListener {

    private SpringApplication application;

    public MySpringAppRunListener(SpringApplication application, String[] args) {
        this.application = application;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MySpringAppRunListener 的 starting 方法执行了");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
                                     ConfigurableEnvironment environment) {
        System.out.println("MySpringAppRunListener 的 environmentPrepared 方法执行了");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringAppRunListener 的 contextPrepared 方法执行了");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringAppRunListener 的 contextLoaded 方法执行了");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("MySpringAppRunListener 的 started 方法执行了");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("MySpringAppRunListener 的 running 方法执行了");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MySpringAppRunListener 的 failed 方法执行了");
    }
    
}
