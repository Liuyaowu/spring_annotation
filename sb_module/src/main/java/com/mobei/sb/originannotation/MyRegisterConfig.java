package com.mobei.sb.originannotation;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * 保证返回的对象是统一个
 */
//@Configuration(proxyBeanMethods = true)
public class MyRegisterConfig {

    @Bean
    public ServletRegistrationBean myServlet () {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/my", "my02");
    }

    @Bean
    public FilterRegistrationBean myFilter () {
        MyFilter myFilter = new MyFilter();
        // 方式1
//        return new FilterRegistrationBean(myFilter, myServlet());

        // 方式2
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter, myServlet());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "my02"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener () {
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }

}
