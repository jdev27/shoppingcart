/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for ResponseJson
 * 
 * @author ruben.ortiz
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseJsonDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5439401005537919003L;

	private ResponseObjectDTO response;

	public ResponseJsonDTO(int code, String title, String message)
	{
		this.response = ResponseObjectDTO.builder() //
		        .code(code) //
		        .title(title) //
		        .message(message) //
		        .build();
	}
}
