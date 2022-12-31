package com.iqvia.bhc.tab.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MD5UtilsTest {

	@Test
	void test() {
		String testStr = "Hello IQVIA, THIS IS A TEST MESSAGE";
		try {
			String md5Str = MD5Utils.MD5_64bit(testStr);
			// MD5 + BASE64
			String assertStr = "9ApZ3JG36BVhJPIEZV88Ww==";
			assertEquals(md5Str, assertStr);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
