package com.mobei.aop.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * BeanPostProcessor: bean后置处理器,bean创建对象初始化前后进行拦截工作的
 *
 * BeanFactoryPostProcessor: BeanFactory后置处理器,在BeanFactory标准初始化后调用,定制和修改BeanFactory的内容
 *                           所有的BeanDefinition已经保存加载到BeanFactory,但是bean的实例还未创建
 *
 * BeanFactoryPostProcessor原理:
 * 1)、ioc容器创建对象
 * 2)、invokeBeanFactoryPostProcessors(beanFactory):
 * 		如何找到所有的BeanFactoryPostProcessor并执行他们的方法；
 * 			1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件,并执行他们的方法
 * 			2）、在初始化创建其他组件前面执行
 *
 *
 *
 */
@ComponentScan(value = "com.mobei.aop.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }

}
