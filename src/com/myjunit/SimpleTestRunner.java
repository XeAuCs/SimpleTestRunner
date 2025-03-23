package com.myjunit;

import java.io.File;
import java.net.URL;
import java.util.Objects;

/**
 * SimpleTestRunner - 这是一个简单的 JUnit 替代工具，可以自动运行测试类中的测试方法。
 *
 * <p>它支持：
 * <ul>
 *   <li>自动查找 `com.tests` 包下的所有测试类</li>
 *   <li>执行以 `test` 开头或带 `@Test` 注解的方法</li>
 *   <li>统计通过和失败的测试数量</li>
 * </ul>
 */
public class SimpleTestRunner {

    /**
     * 程序入口，自动运行 `com.tests` 目录下的所有测试类。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        runAllTests("com.tests"); // 扫描 com.tests 包并运行所有测试类
    }

    /**
     * 自动扫描 package 下的所有类，并执行测试。
     *
     * @param packageName 要扫描的包，例如 "com.tests"
     */
    public static void runAllTests(String packageName) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL packageURL = classLoader.getResource(packageName.replace(".", "/"));

            if (packageURL == null) {
                System.out.println(" 无法找到包: " + packageName);
                return;
            }

            File directory = new File(packageURL.toURI());
            if (!directory.exists()) {
                System.out.println(" 目录不存在: " + directory.getAbsolutePath());
                return;
            }

            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().replace(".class", "");
                    runTests(className); // 运行测试类
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 运行指定类中的所有测试方法。
     *
     * @param className 测试类的全限定名，例如 "com.tests.MyTest"
     */
    public static void runTests(String className) {
        try {
            Class<?> testClass = Class.forName(className);
            int passed = 0, failed = 0;

            for (var method : testClass.getDeclaredMethods()) {
                if (method.getName().startsWith("test") || method.isAnnotationPresent(Test.class)) {
                    try {
                        Object instance = testClass.getDeclaredConstructor().newInstance();
                        method.invoke(instance);
                        System.out.println(" 成功: " + method.getName());
                        passed++;
                    } catch (Exception e) {
                        System.out.println(" 失败: " + method.getName() + " -> " + e.getCause());
                        failed++;
                    }
                }
            }
            System.out.println("测试完成！类: " + className + "，通过: " + passed + "，失败: " + failed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

