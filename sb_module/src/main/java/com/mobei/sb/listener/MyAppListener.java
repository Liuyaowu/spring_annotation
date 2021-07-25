package com.mobei.sb.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyAppListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyAppListener 的 onApplicationEvent方法执行了");
    }

}
