package com.mobei.aop;

import com.mobei.aop.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {

    @Test
    public void testFactoryPostProcessor() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
//        Blue blue = applicationContext.getBean(Blue.class);

        Object hello = applicationContext.getBean("hello");
        System.out.println(hello);
    }

}
