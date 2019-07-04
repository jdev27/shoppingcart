/**
 * 
 */
package com.coding.exercise.shoppingcart.service;

import com.coding.exercise.shoppingcart.dto.CartDTO;

/**
 * @author ruben.ortiz
 *
 */
public interface CartService
{

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CartDTO save(CartDTO dto);
}
