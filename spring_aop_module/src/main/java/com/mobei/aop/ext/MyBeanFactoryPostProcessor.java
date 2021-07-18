package com.mobei.aop.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int beanPostProcessorCount = beanFactory.getBeanPostProcessorCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("BeanFactory 后置处理器方法执行了");
    }
}
