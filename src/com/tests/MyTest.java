package com.tests;

import com.myjunit.Assert;
import com.myjunit.Test;

public class MyTest {

    @Test
    public void testAddition() {
        Assert.assertEquals(4, 2 + 2); // ✅ 这个应该成功
    }

    @Test
    public void testFailure() {
        Assert.assertEquals(5, 2 + 2); // ❌ 这个应该失败
    }

    @Test
    public void testBoolean() {
        Assert.assertTrue(3 > 2);  // ✅ 这个应该成功
        Assert.assertFalse(2 > 3); // ✅ 这个应该成功
    }

    @Test
    public void testNullCheck() {
        Object obj = null;
        Assert.assertNull(obj);  // ✅ 这个应该成功
        Assert.assertNotNull("Hello"); // ✅ 这个应该成功
    }
}

