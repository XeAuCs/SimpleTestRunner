package com.myjunit;

import java.util.ArrayList;
import java.util.List;

/**
 * Assert - 自定义断言工具类
 *
 * <p>提供以下断言方法：
 * <ul>
 *   <li>{@link #assertEquals(Object, Object)} - 断言两个值相等</li>
 *   <li>{@link #assertTrue(boolean)} - 断言条件为 true</li>
 *   <li>{@link #assertFalse(boolean)} - 断言条件为 false</li>
 *   <li>{@link #assertNotNull(Object)} - 断言对象不为 null</li>
 *   <li>{@link #assertNull(Object)} - 断言对象为 null</li>
 *   <li>{@link #assertGreaterThan(Number, Number)} - 断言一个值大于另一个</li>
 *   <li>{@link #assertLessThan(Number, Number)} - 断言一个值小于另一个</li>
 *   <li>{@link #reportErrors()} - 统一报告多个错误</li>
 * </ul>
 */
public class Assert {
    // 用于存储多个断言错误
    private static final List<String> errors = new ArrayList<>();

    /**
     * 断言两个值相等
     *
     * @param expected 期望值
     * @param actual   实际值
     * @throws AssertionError 如果 expected 不等于 actual，则抛出异常
     */
    public static void assertEquals(Object expected, Object actual) {
        if (expected == null && actual == null) {
            return; // 期望值和实际值都为 null，测试通过
        }
        if (expected == null || actual == null || !expected.equals(actual)) {
            String errorMessage = "断言失败: 期望值 " + expected + "，但实际值是 " + actual;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage); // 立即抛出 AssertionError
        }
    }

    /**
     * 断言布尔值为 true
     *
     * @param condition 需要检查的条件
     * @throws AssertionError 如果条件为 false，则抛出异常
     */
    public static void assertTrue(boolean condition) {
        if (!condition) {
            String errorMessage = "断言失败: 期望 true，但得到 false";
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言布尔值为 false
     *
     * @param condition 需要检查的条件
     * @throws AssertionError 如果条件为 true，则抛出异常
     */
    public static void assertFalse(boolean condition) {
        if (condition) {
            String errorMessage = "断言失败: 期望 false，但得到 true";
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言对象不为 null
     *
     * @param object 需要检查的对象
     * @throws AssertionError 如果对象为 null，则抛出异常
     */
    public static void assertNotNull(Object object) {
        if (object == null) {
            String errorMessage = "断言失败: 期望对象不为 null，但得到 null";
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言对象为 null
     *
     * @param object 需要检查的对象
     * @throws AssertionError 如果对象不为 null，则抛出异常
     */
    public static void assertNull(Object object) {
        if (object != null) {
            String errorMessage = "断言失败: 期望 null，但得到 " + object;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言一个数大于另一个数
     *
     * @param actual   实际值
     * @param expected 期望值
     * @throws AssertionError 如果 actual 不大于 expected，则抛出异常
     */
    public static void assertGreaterThan(Number actual, Number expected) {
        if (!(actual.doubleValue() > expected.doubleValue())) {
            String errorMessage = "断言失败: 期望 " + actual + " > " + expected;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 断言一个数小于另一个数
     *
     * @param actual   实际值
     * @param expected 期望值
     * @throws AssertionError 如果 actual 不小于 expected，则抛出异常
     */
    public static void assertLessThan(Number actual, Number expected) {
        if (!(actual.doubleValue() < expected.doubleValue())) {
            String errorMessage = "断言失败: 期望 " + actual + " < " + expected;
            errors.add(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    /**
     * 统一报告所有断言错误
     *
     * <p>如果有多个断言失败，它们都会被收集并统一抛出。
     *
     * @throws AssertionError 包含所有失败的断言信息
     */
    public static void reportErrors() {
        if (!errors.isEmpty()) {
            throw new AssertionError("测试失败:\n" + String.join("\n", errors));
        }
    }
}
