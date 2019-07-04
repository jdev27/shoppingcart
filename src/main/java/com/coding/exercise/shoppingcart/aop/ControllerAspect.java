/**
 * 
 */
package com.coding.exercise.shoppingcart.aop;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.slf4j.LoggerFactory.getLogger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.coding.exercise.shoppingcart.utils.CommonStringUtils;

/**
 * Aspect for Controller
 * 
 * @author ruben.ortiz
 *
 */
@Aspect
@Component
public class ControllerAspect extends BaseAspect
{

	private final Logger logger = getLogger(ControllerAspect.class);

	@Autowired
	private HttpServletRequest request;

	/**
	 * Logs Controller signature at method level
	 * 
	 * @param joinPoint
	 */
	@Before("controllerPointCut()")
	// , @RequestBody Object body
	public void preControllerRequest(JoinPoint joinPoint)
	{
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String controllerName = signature.getDeclaringTypeName();
		Method method = signature.getMethod();
		String methodName = method.getName();

		String httpMethod = request.getMethod();
		String controllerPath = request.getContextPath();
		String reqMappingValue = request.getServletPath();
		Map<String, String> headerMap = new HashMap<>();
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements())
		{
			String key = headers.nextElement();
			headerMap.put(key, request.getHeader(key));
		}

		if (isEmpty(reqMappingValue))
		{
			reqMappingValue = request.getPathInfo();
		}

		Object requestObj = getRequestBody(joinPoint);

		String stringHeader = String.valueOf(headerMap);

		logger.debug(
		        "ControllerName: {}, HttpMethod: {}, Path: {}{}, MethodName: {}",
		        controllerName, httpMethod, controllerPath, reqMappingValue,
		        methodName);

		logger.debug("Header : {}", stringHeader);
		if (requestObj != null)
		{
			String body =
			        CommonStringUtils.convertObjectToJsonString(requestObj);
			logger.debug("RequestBody : {}", body);
		}
	}

	private Object getRequestBody(JoinPoint joinPoint)
	{
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Object requestBody = null;
		for (int i = 0; i < parameterAnnotations.length; i++)
		{
			Annotation[] annotations = parameterAnnotations[i];
			for (Annotation annotation : annotations)
			{
				if (annotation.annotationType() == RequestBody.class)
				{
					requestBody = joinPoint.getArgs()[i];
				}
			}
		}
		return requestBody;
	}
}