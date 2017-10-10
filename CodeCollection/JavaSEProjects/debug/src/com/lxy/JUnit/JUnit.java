package com.lxy.JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnit {

	@BeforeClass
	public static  void beforeClass() {
		System.out.println("beforeClass...");
	}
	@Before
	public void before() {
		System.out.println("before...");
	}
	@Test
	public void eat() {
		System.out.println("eating...");
	}
	@After
	public void after() {
		System.out.println("after...");
	}
	@Test
	public void smile() {
		System.out.println("smiling...");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass...");
	}
	@Ignore
	public void sleep() {
		System.out.println("sleeping...");
	}
}
