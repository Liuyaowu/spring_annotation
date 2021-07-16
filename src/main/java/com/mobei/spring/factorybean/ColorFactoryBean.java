package com.mobei.spring.factorybean;

import com.mobei.spring.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个Color对象到容器中
     *
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否是单例
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
