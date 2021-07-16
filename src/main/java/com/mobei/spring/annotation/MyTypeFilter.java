package com.mobei.spring.annotation;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {

    /**
     * 匹配规则,满足自定义匹配规则并返回true的才会扫描,会扫描@ComponentScan注解的value中指定包名下的所有类
     *
     * @param metadataReader 读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息的工厂类
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 获取当前类的资源: 类路径
        Resource resource = metadataReader.getResource();
        System.out.println(resource.getURI());

        String className = classMetadata.getClassName();
        System.out.println(className);

        // 类名包含ice,比如service
        if (className.contains("ice")) {
            return true;
        }

        return false;
    }
}
