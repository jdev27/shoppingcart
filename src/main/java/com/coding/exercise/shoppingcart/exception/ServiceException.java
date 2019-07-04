/**
 * 
 */
package com.coding.exercise.shoppingcart.exception;

/**
 * @author ruben.ortiz
 *
 */
public class ServiceException extends BaseException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1146514458000348284L;

	public ServiceException(Integer statusCode, String errorTitle,
	        String errorMessage)
	{
		super(statusCode, errorTitle, errorMessage);
	}
}
