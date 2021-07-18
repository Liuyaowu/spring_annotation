package com.mobei.aop.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * BeanDefinitionRegistry: BeanDefinition存储中心,BeanFactory就是按照BeanDefinitionRegistry中保存的
     *  每一个BeanDefinition创建bean实例的
     *
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor-----BeanDefinitionRegistry 后置处理执行, bean的数量: " + registry.getBeanDefinitionCount());

        // 创建bean的方式一
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Blue.class);

        // 创建bean的方式二
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();

        // 往BeanDefinition存储中心BeanDefinitionRegistry中注入一个bean
        registry.registerBeanDefinition("hello", rootBeanDefinition);
    }

    /**
     *
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor------BeanFactory 后置处理执行, bean的数量: " + beanFactory.getBeanDefinitionCount());
    }

}
