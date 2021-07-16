package com.mobei.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类=以前的配置文件
 *
 * @ComponentScan: 要扫描的包,路径下被标注了@Controller、@Service、@Repository、@Component注解的bean就能注入容器
 *                 这是个重复注解,可以在类上加多个,或者用@ComponentScans:
 *                 @ComponentScans(value = { @ComponentScan(value = "com.mobei.spring", useDefaultFilters = false)}
 * )
 *  - excludeFilters:
 *      排除掉加了@Controller、@Service注解的类:
 *          @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
 *
 *  - includeFilters:
 *      会扫描加了Repository和Component注解的类: 如果指定的注解类型出现在exclude中则不会被注入容器
 *          @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Component.class})
 *      ASSIGNABLE_TYPE按照给定的类型扫描,会扫描指定的类型以及他的子类:
 *          @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})
 *      FilterType.REGEX: AspectJ表达式,几乎不用
 *      REGEX: 使用正则表达式
 *      CUSTOM: 自定义规则
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
        includeFilters = {
//                @ComponentScan.Filter(
//                        type = FilterType.ANNOTATION, classes = {Repository.class, Component.class}
//                ),
//                @ComponentScan.Filter(
//                        type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}
//                ),
                @ComponentScan.Filter(
                        type = FilterType.CUSTOM, classes = {MyTypeFilter.class}
                )
        },
        useDefaultFilters = false
)
@Configuration
public class MainConfig {

    /**
     * 给容器注入一个bean,类型为返回值类型,id默认为方法名,也可以通过@Bean注解指定
     *
     * @return
     */
//    @Bean("person1")
//    @Bean
//    public Person person() {
//        return new Person("李四", 20);
//    }

}
