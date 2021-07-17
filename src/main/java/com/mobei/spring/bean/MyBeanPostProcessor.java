package com.mobei.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器:bean初始化前后处理一些事情
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * bean已经初始化完成但是还没有完成属性赋值(比如:InitializingBean's afterPropertiesSet)的时候调用
     *
     * @param bean
     * @param beanName
     * @return 将要返回的对象, 可以直接将bean返回, 也可以对bean做一些封装再返回
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..." + beanName + "=>" + bean);
        if ("car".equals(beanName)) {
            Car car = (Car)bean;
            car.setName("奔驰啊");
            return car;
        }
        return bean;
    }

    /**
     * bean已经初始化完成并且完成属性赋值
     *
     * @param bean
     * @param beanName
     * @return 将要返回的对象, 可以直接将bean返回, 也可以对bean做一些封装再返回
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..." + beanName + "=>" + bean);
        return bean;
    }
}
