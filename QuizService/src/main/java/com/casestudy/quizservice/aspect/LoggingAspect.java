package com.casestudy.quizservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Pointcut("within(com.casestudy.quizservice.service.impl.*)")
	public void inService(){}

	@Pointcut("within(com.casestudy.quizservice.controler.*)")
	public void inController(){}
	
	@Before("inController() || inService()")
	public void logAtMethodStart(JoinPoint joinPoint){
		logger.info(" Method started...", joinPoint.getSignature());
	}
	
	@AfterReturning("inController() || inService()")
	public void logAtMethodEnd(JoinPoint joinPoint){
		logger.info(" Method ended...", joinPoint.getSignature());
	}
	
	@AfterThrowing("inController() || inService()")
	public void logAtException(JoinPoint joinPoint){
		logger.error(" Exception occured...", joinPoint.getSignature());
	}

}
