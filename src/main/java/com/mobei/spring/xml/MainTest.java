package com.mobei.spring.xml;

import com.mobei.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        // 读取类路径下的文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }

}
