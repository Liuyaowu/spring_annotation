package com.mobei.sb.config;

import com.mobei.sb.bean.Car;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableConfigurationProperties需要放在配置类中使用,作用:
 *  - 开启Car配置绑定功能
 *  - 把注解中指定的类注入到容器中
 * 也就是说如果Car这个类使用了注解比如@Component注入到了容器,那么这个注解可以不要写,
 * 或者Car这个类没有使用注解比如@Component注入到容器,那么可以使用该注解注入
 */
@Configuration
@EnableConfigurationProperties(Car.class)
public class MyConfig {



}
