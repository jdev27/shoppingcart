/**
 * 
 */
package com.coding.exercise.shoppingcart.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author ruben.ortiz
 *
 */
public abstract class BaseAspect
{

	protected static final String CONTROLLER_PACKAGE_POINT_CUT =
	        "execution(* com.coding.exercise.shoppingcart.controller..*(..))";

	protected static final String SERVICE_PACKAGE_POINT_CUT =
	        "execution(* com.coding.exercise.shoppingcart..*(..))";

	@Pointcut(SERVICE_PACKAGE_POINT_CUT)
	public void servicePointCut()
	{
		// pointcut
	}

	@Pointcut(CONTROLLER_PACKAGE_POINT_CUT)
	public void controllerPointCut()
	{
		// pointcut
	}

	protected HttpServletRequest getHttpServletRequest()
	{

		RequestAttributes reqAttributes =
		        RequestContextHolder.getRequestAttributes();
		if (reqAttributes != null)
		{
			return ((ServletRequestAttributes) reqAttributes).getRequest();
		}
		return null;
	}
}
