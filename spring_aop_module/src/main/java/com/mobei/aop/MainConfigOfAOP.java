package com.mobei.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP: 动态代理,指在程序运行期间动态将某段代码切入到指定方法指定位置进行运行的编程模式
 *
 * 1、导入AOP模块(spring-aspects)
 * 2、定义一个业务逻辑类:比如这里的MathCalculator的div方法
 * 3、定义一个日志切面类(LogAspects):
 *      前置通知(@Before): 在目标方法(div)运行之前运行
 *      后置通知(@After): 在目标方法(div)运行结束之后运行(无论方法正常结束还是异常结束)
 *      返回通知(@AfterReturning): 在目标方法(div)正常返回之后运行
 *      异常通知(@AfterThrowing): 在目标方法(div)出现异常以后运行
 *      环绕通知(@Around): 动态代理,手动推进目标方法运行（joinPoint.procced()）
 * 4、给切面类的目标方法标注何时何地运行(通知注解)
 * 5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6、必须告诉Spring哪个类是切面类(给切面类上加一个注解：@Aspect)
 * 7、给配置类中加 @EnableAspectJAutoProxy[开启基于注解的aop模式]
 *
 * @EnableAspectJAutoProxy注解:
 *  - 元注解@Import(AspectJAutoProxyRegistrar.class): 给容器中导入AspectJAutoProxyRegistrar
 *      - AspectJAutoProxyRegistrar自定义给容器中注册bean:
 *          id为internalAutoProxyCreator,类型为AnnotationAwareAspectJAutoProxyCreator
 *
 * AnnotationAwareAspectJAutoProxyCreator的作用:
 * 		AnnotationAwareAspectJAutoProxyCreator继承结构:
 * 			->AspectJAwareAdvisorAutoProxyCreator
 * 				->AbstractAdvisorAutoProxyCreator
 * 					->AbstractAutoProxyCreator: implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 * 						SmartInstantiationAwareBeanPostProcessor: 后置处理器(在bean初始化完成前后做事情)
 * 						BeanFactoryAware: void setBeanFactory(BeanFactory beanFactory): 自动装配BeanFactory
 *
 * AbstractAutoProxyCreator: setBeanFactory() + 后置处理器的逻辑
 *  子类AbstractAdvisorAutoProxyCreator重写setBeanFactory(): 会调用initBeanFactory()方法
 *      AnnotationAwareAspectJAutoProxyCreator: 重写了initBeanFactory()方法,并且方法第一行调用了父类的这个方法: 父类方法就干了一件事--new BeanFactoryAdvisorRetrievalHelperAdapter(beanFactory)
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    /**
     * 将业务逻辑类加入容器中
     *
     * @return
     */
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    /**
     * 将切面类加入到容器中
     *
     * @return
     */
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

}
