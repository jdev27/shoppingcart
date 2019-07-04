/**
 * 
 */
package com.coding.exercise.shoppingcart.aop;

import static com.coding.exercise.shoppingcart.constant.AppConstants.COMMA;
import static com.coding.exercise.shoppingcart.constant.AppConstants.LOG_DURATION;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.slf4j.LoggerFactory.getLogger;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author ruben.ortiz
 *
 */
@Aspect
@Component
public class DurationAspect extends BaseAspect
{

	private final Logger log = getLogger(DurationAspect.class);

	@Around("servicePointCut() || controllerPointCut()")
	public Object logDuration(ProceedingJoinPoint joinPoint) throws Throwable
	{
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String serviceName = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		String methodName = method.getName();
		String parameter = formatParameterTypes(method.getParameterTypes());

		long start = new Date().getTime();
		try
		{
			return joinPoint.proceed();
		}
		finally
		{
			logDuration(serviceName, methodName, parameter, start);
		}
	}

	/**
	 * 
	 * @param serviceName
	 * @param methodName
	 * @param parameter
	 * @param start
	 */
	private void logDuration(String serviceName, String methodName,
	        String parameter, long start)
	{
		long end = new Date().getTime();
		log.debug(LOG_DURATION, serviceName, methodName, parameter,
		        (end - start));
	}

	/**
	 * 
	 * @param parameters
	 * @return
	 */
	private String formatParameterTypes(Class<?>[] parameters)
	{
		int counter = 0;
		int size = parameters.length;
		StringBuilder sb = new StringBuilder();
		for (Class<?> clazz : parameters)
		{
			sb.append(clazz.getName());
			if (++counter < size)
			{
				sb.append(COMMA);
				sb.append(SPACE);
			}
		}
		return sb.toString();
	}
}
