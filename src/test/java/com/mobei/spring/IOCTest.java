package com.mobei.spring;

import com.mobei.spring.annotation.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    @Test
    public void testComponentScan() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String item : beanDefinitionNames) {
            System.out.println(item);
        }
    }

}
