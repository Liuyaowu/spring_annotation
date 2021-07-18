package com.mobei.aop.applicationlistener;

import com.mobei.aop.ext.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ApplicationListener: 监听容器中发布的事件,事件驱动模型开发
 * public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 * 监听ApplicationEvent(事件)及其下面的子事件
 *
 * 使用步骤:
 *  1、写一个监听器来监听某个事件(ApplicationEvent及其子类)或者在需要监听的方法上加上@EventListener注解
 *  2、把监听器加入到容器
 *  3、只要容器中有相关事件的发布就能监听到该事件,比如Spring自己相关的事件:
 *          ContextRefreshedEvent: 容器刷新完成(所有bean都完全创建)会发布这个事件
 *          ContextClosedEvent: 容器关闭会发布该事件
 *  4、发布事件: applicationContext.publishEvent;
 *
 */
@ComponentScan(value = "com.mobei.aop.applicationlistener")
@Configuration
public class ApplicationListenerConfig {
    @Bean
    public Blue blue() {
        return new Blue();
    }
}
