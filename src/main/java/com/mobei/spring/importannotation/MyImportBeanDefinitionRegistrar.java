package com.mobei.spring.importannotation;

import com.mobei.spring.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 往容器中注入
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类,把所有需要添加到容器中的bean,
     *                 可以通过BeanDefinitionRegistry的registerBeanDefinition手动注册到容器中
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean existRed = registry.containsBeanDefinition("com.mobei.spring.bean.Blue");
        boolean existBlue = registry.containsBeanDefinition("com.mobei.spring.bean.Red");

        if (existRed && existBlue) {
            // 指定Bean的定义信息
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);

            // 往Spring注入bean
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }

    }
}
