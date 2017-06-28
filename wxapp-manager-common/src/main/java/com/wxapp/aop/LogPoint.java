package com.wxapp.aop;

import org.aspectj.lang.JoinPoint;

/**
 * <p>
 * 日志切入点接口类
 * </p>
 * 
 * @author Carry xie
 * @Date 2016-05-09
 */
public interface LogPoint {

	void saveLog(JoinPoint joinPoint, String methodName, String operate);
	void saveLog(JoinPoint joinPoint, String methodName, Throwable e);

}
