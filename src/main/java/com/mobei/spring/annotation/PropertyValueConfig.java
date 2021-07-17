package com.mobei.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 使用@PropertySource加载外部配置文件中的k-v并保存到运行时的环境变量中
 */
@ComponentScan(value = "com.mobei.spring.bean")
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class PropertyValueConfig {
}
