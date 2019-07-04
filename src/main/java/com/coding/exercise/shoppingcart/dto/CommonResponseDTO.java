/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

import lombok.Data;

/**
 * @author ruben.ortiz
 *
 */
@Data
public class CommonResponseDTO<T>
{

	private ResponseObjectDTO response;

	private T data;
}
