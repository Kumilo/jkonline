package com.hemax.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DateTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		long now = System.currentTimeMillis();
		DateFormat sdFormat = SimpleDateFormat.getInstance();//("yyyyMMddHHmm");
		//sdFormat.format(obj)
		System.out.println(sdFormat.format((now)));
		
		
	}

}
