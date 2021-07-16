package com.mobei.spring.annotation;

import com.mobei.spring.importannotation.MyImportBeanDefinitionRegistrar;
import com.mobei.spring.importannotation.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@ComponentScan(
        value = "com.mobei.spring",
//        excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//        },
//        includeFilters = {
//                @ComponentScan.Filter(
//                        type = FilterType.ANNOTATION, classes = {Repository.class, Component.class}
//                ),
//                @ComponentScan.Filter(
//                        type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}
//                ),
//                @ComponentScan.Filter(
//                        type = FilterType.CUSTOM, classes = {MyTypeFilter.class}
//                )
//        },
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


    /**
     * @Conditional: 按照一定的条件进行判断,满足条件给容器中注册bean
     *      加载方法上对方法生效,加在类上那么这个类中所有的bean满足条件才会被注入
     *
     * 如果是windows系统给容器中注入bill, 如果是linux系统给容器中注入linus
     *
     * @return
     */
//    @Conditional(value = {WindowsCondition.class})
//    @Bean("bill")
//    public Person person01() {
//        return new Person("Bill Gates", 62);
//    }
//
//    @Conditional(value = {LinuxCondition.class})
//    @Bean("linus")
//    public Person person02() {
//        return new Person("Linus", 55);
//    }

    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件): 容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector: 返回需要导入的组件的全类名数组；
     * 		3）、ImportBeanDefinitionRegistrar: 手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
     * 			&colorFactoryBean
     */
//    @Bean
//    public ColorFactoryBean colorFactoryBean(){
//        return new ColorFactoryBean();
//    }

}
