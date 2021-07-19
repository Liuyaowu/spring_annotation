package com.mobei.sb;

import com.mobei.sb.bean.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApp.class, args);

        Car bean = applicationContext.getBean(Car.class);
        System.out.println(bean);


    }

}
