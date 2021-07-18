package com.mobei.spring.annotation;

import com.mobei.spring.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringValueResolver;

/**
 * Profile: Spring为我们提供的可以根据当前环境动态激活和切换一系列组件的功能
 *
 *  1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 *  2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 *  3）、没有标注环境标识的bean在，任何环境下都是加载的；
 */
@Configuration
public class ProfileConfig implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public String dataSourceTest(@Value("${db.password}")String pwd) throws Exception{
        return pwd;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public String dataSourceDev(@Value("${db.password}")String pwd) throws Exception{
        return pwd;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public String dataSourceProd(@Value("${db.password}")String pwd) throws Exception{
        return pwd;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;

    }

}
