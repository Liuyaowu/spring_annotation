package com.mobei.sb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@SpringBootTest
public class Junit5AssertTest {

    @DisplayName("测试前置条件")
    @Test
    void testAssumptions() {
        assumeTrue(false, "结果不是true");
    }

    /**
     * 断言: 前面断言失败,后面的代码都不会执行
     */
    @Test
    void testSimpleAssertions() {
        int cal = cal(2, 3);
        // 断言预期值与真实值是否相等
//        assertEquals(5, cal);
        assertEquals(5, cal, "断言失败");

        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2);
    }

    int cal(int i, int j) {
        return i + j;
    }

    @Test
    @DisplayName("array assertion")
    void array() {
        // 断言数组长度是否相等
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数组内容不相等");
    }

    @Test
    @DisplayName("组合断言")
    void all() {
        // 所有断言全部需要成功
        assertAll("test",
                () -> assertTrue(true && true, "结果不为true"),
                () -> assertEquals(1, 2, "结果不是1"));
    }

    @DisplayName("异常断言")
    @Test
    void testException() {
        //断定业务逻辑一定出现异常: 如果抛出异常表示正常,这里业务正常执行没有抛出异常,所以报AssertionFailedError错误
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 2;
        }, "业务逻辑是否正常执行");
    }

    @DisplayName("快速失败")
    @Test
    void testFail() {
        //xxxxx
        if (1 == 2) {
            fail("测试失败");
        }
    }

}
