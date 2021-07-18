package com.mobei.aop;

import com.mobei.aop.applicationlistener.ApplicationListenerConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationListenerTest {
    @Test
    public void testListener() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationListenerConfig.class);

        // 发布自定义的事件
        applicationContext.publishEvent(new ApplicationEvent("自定义发布的事件"){

        });

        applicationContext.close();
    }

}
