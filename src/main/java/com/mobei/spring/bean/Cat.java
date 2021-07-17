package com.mobei.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor...");
    }

    /**
     * 容器关闭的时候调用
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }

    /**
     * bean创建完成并且赋值以后调用
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }

}
