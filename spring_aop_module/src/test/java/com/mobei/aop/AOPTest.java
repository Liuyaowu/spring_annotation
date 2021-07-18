package com.mobei.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    @Test
    public void testAOP() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);


    }

}
