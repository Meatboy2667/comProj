package com.example.car.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //���������� �����ϴ� ���� bean
@Aspect //�������� ������ �����ϴ� bean
public class LogAdvice {
	
	//�α��� ���� ����
	private static final Logger logger 
	  = LoggerFactory.getLogger(LogAdvice.class);
	//@Before(�ٽɾ��� ��), @After(�ٽɾ��� ��), @Around(��,��)
	//@����execution( *"����"+"����"+"����"..)
	//.. ��� ������Ű���� �ǹ�, *(..) ��� �޼ҵ带 �ǹ�
	
	/*@Around(
	"execution(* com.example.spring02.controller..*Controller.*(..))"
		+ " or execution(* com.example.spring02.service..*Impl.*(..))"
		+ " or execution(* com.example.spring02.model..dao.*Impl.*(..))")*/
	
	public Object logPrint(ProceedingJoinPoint joinPoint) 
			throws Throwable { //�ٽɾ����� ����Ǵ� ����
		long start=System.currentTimeMillis();//�ý����� �и����ϵ尪
		
		Object result=joinPoint.proceed();
		//ȣ���� Ŭ���� �̸�(getDeclaringTypeName())
		String type=joinPoint.getSignature().getDeclaringTypeName();
		String name="";
		if(type.indexOf("Controller") > -1) {
			name="Controller \t:";// ��ó��
		}else if(type.indexOf("Service") > -1) {
			name="ServiceImpl \t:";
		}else if(type.indexOf("DAO") > -1) {
			name="DaoImpl \t:";
		}
		
		//ȣ���� Ŭ����, method ������ �ΰſ� ����
		logger.info(name+type+"."+joinPoint.getSignature().getName()+"()");
		//method�� ���޵Ǵ� �Ű��������� �ΰſ� ����
		logger.info(Arrays.toString(joinPoint.getArgs()));
		long end=System.currentTimeMillis();
		long time=end-start;
		logger.info("����ð�:" + time);
		return result;
	}
}
