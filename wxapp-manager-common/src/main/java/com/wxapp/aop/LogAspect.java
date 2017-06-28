package com.wxapp.aop;

import com.wxapp.annotations.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p>
 * 日志切面处理类
 * </p>
 *
 * @author Carry xie
 * @Date 2016-05-09
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    /**
     *
     */
    @Autowired
    private LogPoint logPoint;


    @Pointcut("@annotation(com.wxapp.annotations.Log)")
    public void sysLogAspect() {
    }

    /**
     * 保存系统操作日志
     *
     * @param joinPoint 连接点
     * @return 方法执行结果
     */
    @Around("sysLogAspect()")
    //@Around(value = "@annotation(com.podinns.annotations.Log)")
    public Object saveLog(JoinPoint joinPoint) throws Throwable {
        /**
         *
         */
        String methodName = joinPoint.getSignature().getName();
        Method method = currentMethod(joinPoint, methodName);
        Log log = method.getAnnotation(Log.class);

        /**
         *
         */
        if (log != null) {
            logPoint.saveLog(joinPoint, methodName, log.value());
        }

        /**
         *
         */
        return ((ProceedingJoinPoint) joinPoint).proceed();
    }

    /**
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 方法
     */
    private Method currentMethod(JoinPoint joinPoint, String methodName) {

        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

    public LogPoint getLogPoint() {
        return logPoint;
    }

    public void setLogPoint(LogPoint logPoint) {
        this.logPoint = logPoint;
    }


    @Pointcut("execution(* com.wxapp.controller..*.*(..)) "
            + "|| execution(* com.wxapp.service..*.*(..))")
    public void exceptionLogCall() {
    }

    @AfterThrowing(pointcut = "exceptionLogCall()", throwing = "e")
    public void doThrowing(JoinPoint joinPoint, Exception e) {
        e.printStackTrace();
        try {
            logPoint.saveLog(joinPoint, joinPoint.getSignature().getName(), e);
        } catch (Exception exp) {
            logger.error("异常信息:{}", exp.getMessage());

        }
    }
}