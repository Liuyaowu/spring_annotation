package com.mobei.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断当前系统是不是linux系统
 */
public class LinuxCondition implements Condition {

    /**
     *
     *
     * @param context 判断条件能使用的上下文(环境)
     * @param metadata 标注了该注解的注解信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1、能获取到IOC使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        // 3、获取当前环境信息
        Environment environment = context.getEnvironment();

        // 4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String systemName = environment.getProperty("os.name");

        return systemName.contains("Linux");
    }
}
