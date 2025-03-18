# SimpleTestRunner - 轻量级 Java 测试框架

## 功能
- 自动运行 `com.tests` 目录下的所有测试类
- 识别 `@Test` 注解或 `test` 开头的方法
- 提供 `Assert.assertEquals()`、`Assert.assertTrue()` 断言方法
- 统计测试通过/失败情况

## 运行测试
1. 编译项目：
   ```bash
   javac -d out -sourcepath src $(find src -name "*.java")
