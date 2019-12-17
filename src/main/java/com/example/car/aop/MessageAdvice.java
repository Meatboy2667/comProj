package com.example.car.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //��Ÿ ���� bean
@Aspect // aop bean - ���� ������ �����ϴ� �ڵ�
public class MessageAdvice {
	private static final Logger logger
	=LoggerFactory.getLogger(MessageAdvice.class);
	@Before("execution(* " 
	+ " com.example.spring02.service.message" 
	+ ".MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		//JoinPoint : @After, @Before�� �� ���
		logger.info("�ٽ� ���� �ڵ��� ����:"+jp.getSignature());
		logger.info("method:"+jp.getSignature().getName());
		logger.info("�Ű�����:"+Arrays.toString(jp.getArgs()));
	}
	@Around("execution(* " 
			+ " com.example.spring02.service.message" 
			+ ".MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint  pjp) throws Throwable {
        //ProceedingJoinPoint : @Around�϶��� ���
		long start=System.currentTimeMillis();
		Object result=pjp.proceed();
		
		long end=System.currentTimeMillis();
		logger.info(pjp.getSignature().getName()+":"+(end-start));
		logger.info("==========================");
		return result;
	}
}
