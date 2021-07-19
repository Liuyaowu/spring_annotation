package com.mobei.sb.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 通过@ConfigurationProperties注解以及prefix指定的前缀,
 * 将properties文件中的属性注入到这个类中.需要注意的是必须注入容器中的组件才会拥有这个功能.
 *
 */
@Data
//@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;

    private Integer price;

}
