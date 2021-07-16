package com.mobei.spring.importannotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值就是要导入到容器中的组件全类名
     *
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 要导入到容器中的组件全类名,可以返回空数组,但是一定不要返回null,会出现空指针异常
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 在容器中的id是全路径类名com.mobei.spring.bean.Blue、com.mobei.spring.bean.Red
        // 如果类上加了@Component注解则id是类名首字母小写的类名
        return new String[]{"com.mobei.spring.bean.Red", "com.mobei.spring.bean.Blue"};
    }

}
