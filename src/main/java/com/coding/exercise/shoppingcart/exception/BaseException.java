/**
 * 
 */
package com.coding.exercise.shoppingcart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ruben.ortiz
 *
 */
@AllArgsConstructor
@Getter
public class BaseException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4034036471775763038L;

	private final Integer statusCode;

	private final String errorTitle;

	private final String errorMessage;
}
