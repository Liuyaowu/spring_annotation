package com.mobei.spring.annotation;

import com.mobei.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类=配置文件
 */
@Configuration
public class MainConfig {

    /**
     * 给容器注入一个bean,类型为返回值类型,id默认为方法名,也可以通过@Bean注解指定
     *
     * @return
     */
//    @Bean("person1")
    @Bean
    public Person person() {
        return new Person("李四", 20);
    }

}
