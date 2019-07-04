package com.coding.exercise.shoppingcart.exception;

/**
 * @author ruben.ortiz
 *
 */
public class ControllerException extends BaseException
{

	public ControllerException(Integer statusCode, String errorTitle,
	        String errorMessage)
	{
		super(statusCode, errorTitle, errorMessage);
	}

	/**
		 * 
		 */
	private static final long serialVersionUID = -4624619412152893805L;

}
