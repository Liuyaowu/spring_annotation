package com.mobei.spring.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 自定义逻辑返回需要导入的组件
 */
@EnableAsync
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值就是要导入到容器中的组件全类名
     *
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 要导入到容器中的组件全类名,可以返回空数组,但是一定不要返回null,会出现空指针异常
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.mobei.spring.bean.Blue", "com.mobei.spring.bean.Red"};
    }

}
