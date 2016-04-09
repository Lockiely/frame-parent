package com.lockiely.easy.intercepter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.lockiely.easy.pojo.Admin;

@Aspect
@Component
public class LogAspect {
	
	@Pointcut("execution(* com.lockiely.easy.service.*.findAdminByNickname(..))")
	public void pointCut(){}
	
	@AfterReturning(value="pointCut()", returning="returnValue")
	public void logServiceCallback(JoinPoint joinPoint, Object returnValue){
		StopWatch c = new StopWatch();
		c.start();
		
		Admin admin = (Admin) returnValue;
		String methodName = joinPoint.getSignature().getName();
		StringBuilder sb = new StringBuilder();
		sb.append(methodName);
		
		
	}
}
