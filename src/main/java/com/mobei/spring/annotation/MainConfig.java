package com.mobei.spring.annotation;

import com.mobei.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类=以前的配置文件
 *
 * @ComponentScan: 要扫描的包,路径下被标注了@Controller、@Service、@Repository、@Component注解的bean就能注入容器
 *                 这是个重复注解,可以在类上加多个,或者用@ComponentScans:
 *                 @ComponentScans(value = { @ComponentScan(value = "com.mobei.spring", useDefaultFilters = false)}
 * )
 *  - excludeFilters:
 *      排除掉加了@Controller、@Service注解的类: @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
 *
 *  - includeFilters:
 *      只扫描加了Repository和Component注解的类: @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Component.class})
 *
 *  - useDefaultFilters = false: 禁用掉默认的过滤规则,对excludeFilters和includeFilters没影响,
 *      但是如果没有这两个过滤规则,那么只会扫描@Component注解的类
 *
 *
 *
 *
 */
@ComponentScan(
        value = "com.mobei.spring",
//        excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//        },
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Component.class})
//        },
        useDefaultFilters = false
)
//@ComponentScans(
//        value = {
//                @ComponentScan(value = "com.mobei.spring", useDefaultFilters = false)
//        }
//)
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
