package com.mobei.spring;

import com.mobei.spring.annotation.MainConfig;
import com.mobei.spring.annotation.MainConfigOfLifeCycle;
import com.mobei.spring.annotation.PropertyValueConfig;
import com.mobei.spring.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

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

    @Test
    public void testFactoryBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        // 工厂Bean获取的是ColorFactoryBean的方法getObject返回的对象
        Object color = applicationContext.getBean("colorFactoryBean");
        // 输出的是: class com.mobei.spring.bean.Color
        System.out.println(color.getClass());

        // 如果要获取ColorFactoryBean自身的对象需要在colorFactoryBean前面加&符号
        Object colorFactoryBean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
    }

    @Test
    public void testLifeCycle() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String item : beanDefinitionNames) {
            System.out.println(item);
        }
        Object car = applicationContext.getBean("car");
        System.out.println(car);
        applicationContext.close();
    }

    @Test
    public void testPropertySource() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyValueConfig.class);
        Object car = applicationContext.getBean("person");
        System.out.println(car);

        // 被Spring容器读取到的配置文件中的配置信息可以通过配置环境类获取到
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("prop.name");
        System.out.println(property);

    }

}
