package com.tests;

import com.myjunit.Assert;
import com.myjunit.Test;

public class MyTest2 {

    // 1️⃣ 基础断言测试
    @Test
    public void testBasicAssertions() {
        Assert.assertEquals(10, 5 + 5);  // ✅ 通过
        Assert.assertTrue(3 > 1);        // ✅ 通过
        Assert.assertFalse(2 > 3);       // ✅ 通过
    }

    // 2️⃣ 断言 null 和非 null
    @Test
    public void testNullAssertions() {
        Assert.assertNull(null);         // ✅ 通过
        Assert.assertNotNull("Hello");   // ✅ 通过
    }

    // 3️⃣ 测试方法是否抛出异常
    @Test
    public void testException() {
        try {
            int result = 10 / 0;  // ❌ 这里会抛出异常
            Assert.assertTrue(false); // 如果执行到这里，说明测试失败
        } catch (ArithmeticException e) {
            Assert.assertTrue(true);  // ✅ 测试通过，捕获到预期异常
        }
    }

    // 4️⃣ 测试方法执行时间
    @Test
    public void testPerformance() {
        long startTime = System.nanoTime();

        // 模拟一个执行时间较长的操作
        double result = 0;
        for (int i = 0; i < 1000000; i++) {
            result += Math.sqrt(i);
        }

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1e6; // 转换成毫秒

        // 1️⃣ 断言执行时间不超过 100ms
        Assert.assertTrue(durationMs < 10);

        // 2️⃣ 确保计算结果正确
        Assert.assertTrue(result > 0);

        System.out.println("✅ testPerformance 执行时间: " + durationMs + "ms");
    }


    // 5️⃣ 测试边界值（如 Integer.MAX_VALUE）
    @Test
    public void testBoundaryValues() {
        Assert.assertEquals(Integer.MAX_VALUE, 2147483647);
        Assert.assertEquals(Integer.MIN_VALUE, -2147483648);
    }
}
