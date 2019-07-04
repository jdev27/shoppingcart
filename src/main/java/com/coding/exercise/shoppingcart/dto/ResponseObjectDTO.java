/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author ruben.ortiz
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseObjectDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1403230643145250123L;

	private Integer code;

	private String title;

	private String message;

	/**
	 * 
	 * @param code
	 */
	public ResponseObjectDTO(Integer code)
	{
		this.code = code;
	}
}
