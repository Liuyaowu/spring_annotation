package com.mobei.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 自动装配原理:
 *
 * @SpringBootConfiguration: 有一个@Configuration的元注解,代表当前类是一个配置类
 * @ComponentScan: 指定要扫描哪些包
 * @EnableAutoConfiguration: 核心注解,有两个元注解
 *  - @AutoConfigurationPackage: 自动配置包,往容器中注入了一个类AutoConfigurationPackages.Registrar:@Import(AutoConfigurationPackages.Registrar.class)
 *                              static class Registrar implements ImportBeanDefinitionRegistrar, DeterminableImports
 *                              ImportBeanDefinitionRegistrar: 重写了这个接口的方法registerBeanDefinitions方法,方法有两个参数
 *                                  - AnnotationMetadata metadata: 注解的元注解,即标注在哪个类上面就有这个类的所有注解信息,这个注解标注在@AutoConfigurationPackage上,
 *                                                                 最终标注在MainApp上,所以最终就会有MainApp这个类上面的所有注解信息
 *                                  - BeanDefinitionRegistry registry: BeanDefinition注册器,在这个方法里面执行了
 *                                                              register(registry, new PackageImports(metadata).getPackageNames().toArray(new String[0])),
 *                                                              通过metadata元注解获取到标注该类所在的包,这里就是com.mobei.sb,这里就是把包信息的BeanDefinition注入到了容器
 *
 *  - @Import(AutoConfigurationImportSelector.class): 导入了一个类AutoConfigurationImportSelector
 *          AutoConfigurationImportSelector: 在selectImports方法中调用了getAutoConfigurationEntry(annotationMetadata),将元注解传入进去
 *              getAutoConfigurationEntry方法: 会调用getCandidateConfigurations方法,这个方法会调用SpringFactoriesLoader.loadFactoryNames
 *                  SpringFactoriesLoader.loadFactoryNames: 调用loadSpringFactories,会去读取FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories"下面的配置文件,
 *                                                          默认会读取当前系统所有这个目录下的配置文件,其中在autoconfigure的配置文件中有一个属性
 *                                                          org.springframework.boot.autoconfigure.EnableAutoConfiguration,里面指定了所有场景下默认需要导入
 *                                                          Spring容器的自动配置组件,都是以AutoConfiguration结尾的自动配置类.
 *
 *  虽然场景下所有自动配置启动的时候默认全部加载,但是最终会按需配置(这些类本身就是配置类,注入容器的时候会根据条件比如@Conditional、@ConditionalOnMissingBean等等去判断是否需要加载),
 *  只有在配置了相关场景启动器的情况下才会加载
 *
 */
//@ServletComponentScan(value = "com.mobei.sb.originannotation")
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApp.class, args);

//        Car bean = applicationContext.getBean(Car.class);
//        System.out.println(bean);
    }

}
