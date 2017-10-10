package com.netease.course.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author menglanyingfei
 * @date 2017-8-26
 */

@Aspect
public class LoggingAspect {
	/**
	 * 正常返回时调用
	 * 
	 * @param jp调用点信息
	 */
	@AfterReturning("execution(* com.netease.course.service.*.*(..))")
	public void loggindAfterReturning(JoinPoint jp) {
		String className = jp.getSignature().getDeclaringTypeName();
		String methodName = jp.getSignature().getName();
		System.out.print("正常返回Logging:调用" + className + "的" + methodName
				+ "方法, 参数为：");
		for (Object obj : jp.getArgs()) {
			System.out.print(obj.toString());
		}
		System.out.println("");
	}

	/**
	 * 抛出异常返回时调用
	 * 
	 * @param jp
	 *            调用点信息
	 * @param ex
	 *            异常信息
	 */
	@AfterThrowing(pointcut = "execution(* com.netease.course.service.*.*(..))", throwing = "ex")
	public void loggingAfterThrowing(JoinPoint jp, Exception ex) {
		String className = jp.getSignature().getDeclaringTypeName();
		String methodName = jp.getSignature().getName();
		System.out.print("异常Logging:调用" + className + "的" + methodName + "方法, 参数为：");
		for (Object obj : jp.getArgs()) {
			System.out.print(obj.toString());
		}
		System.out.println("。抛出异常:" + ex.getMessage() + "!");
	}
}
