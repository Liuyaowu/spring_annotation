package com.mobei.sb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @DisplayName: 为测试类或方法设置展示的名称
 *
 * @SpringBootTest: 和SB整合需要的注解,否则无法获取注入容器的对象
 *
 */
@DisplayName("测试JUNI5注解")
@Slf4j
@SpringBootTest
public class Junit5Test {

    /**
     * 每个单元测试之前执行
     */
    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了");
    }

    /**
     * 所有单元测试之前执行: 方法必须是static的,通过类执行所有方法时这个方法会最先调用,并且只会执行一次
     */
    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }

    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName() {
        System.out.println("testDisplayName测试方法执行了");
    }

    @DisplayName("第二个测试方法")
    @Test
    void test2() {
        System.out.println("第二个测试方法执行了");
    }

    /**
     * 被@Disabled注解的测试方法不会执行
     */
    @Disabled
    @DisplayName("testDisabled方法")
    @Test
    void testDisabled() {
        System.out.println("testDisabled方法执行了");
    }

    /**
     * 模拟重复测试:会执行指定的次数
     */
    @RepeatedTest(5)
    @Test
    void testRepeat() {
        System.out.println("testRepeat方法执行了");
    }

    /**
     * @Timeout规定方法超时时间,超出时间抛出异常
     */
    @Timeout(value = 5, unit = TimeUnit.MILLISECONDS)
    @DisplayName("testTimeOUT方法")
    @Test
    void testTimeOUT() throws InterruptedException {
        Thread.sleep(600);
        System.out.println("testTimeOUT方法执行了");
    }

    /**
     * 每个单元测试之后执行
     */
    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了");
    }

    /**
     * 所有单元测试之后执行: 方法必须是static的,通过类执行所有方法时这个方法会最后调用,并且只会执行一次
     */
    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试结束了");
    }

}
