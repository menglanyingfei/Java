package com.netease.course;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	@SuppressWarnings("unused")
	@Before("execution(* com.netease.course.Calculator.*(..)) && args(a, ..)")
	private void arithmeticDoLog(JoinPoint jp, int a) {
		System.out.println(a + " : " + jp.toString());
	}
	
}
