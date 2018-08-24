package com.zjrc.sxzz.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zjrc.sxzz.ImClientResponse;

/**捕获异常，统一进行响应
 * @author Administrator
 *
 */
@Aspect
@Component
public class ExceptionAspect {
	
	private static Logger log = LoggerFactory.getLogger(ExceptionAspect.class);
	
	
	@Around("execution(public * com.zjrc.sxzz.controller.*.*(..))")
	public Object responseExcep(ProceedingJoinPoint jp) {
		try {
			log.info("ExceptionAspect 切面开始工作");
			return jp.proceed();
		} catch (Throwable e) {
			log.info("ExceptionAspect 切面捕获到异常，进行响应");
			e.printStackTrace();
			return new ImClientResponse("1", e.getMessage(), null);
		}
	}
}
