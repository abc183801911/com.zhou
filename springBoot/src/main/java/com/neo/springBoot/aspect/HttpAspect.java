package com.neo.springBoot.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.neo.springBoot.controller.SiteInfoController.*(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void dobeforelog(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("url={}",request.getRequestURI());
		logger.info("method={}",request.getMethod());
		logger.info("ip={}",request.getRemoteAddr());
		logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("agrs={}",joinPoint.getArgs());
	}

	@After("log()")
	public void doafterlog() {
		logger.info("2222222222222");
	}
	
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object) {
		logger.info("response={}",object.toString());
	}
}
