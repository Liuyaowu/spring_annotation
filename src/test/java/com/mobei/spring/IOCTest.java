package com.mobei.spring;

import com.mobei.spring.annotation.MainConfig;
import com.mobei.spring.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    @Test
    public void testComponentScan() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String item : beanDefinitionNames) {
//            System.out.println(item);
//        }

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }

    @Test
    public void testImportSelector() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String item : beanDefinitionNames) {
            System.out.println(item);
        }
    }

}
