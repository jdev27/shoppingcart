/**
 * 
 */
package com.coding.exercise.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coding.exercise.shoppingcart.dto.CartDTO;
import com.coding.exercise.shoppingcart.dto.ResponseJsonDTO;
import com.coding.exercise.shoppingcart.service.CartService;

/**
 * @author ruben.ortiz
 *
 */
@RestController
public class CartController extends BaseController
{

	private static final String PATH_SAVE_CART = "saveCart";

	@Autowired
	private CartService cartService;

	@PostMapping(PATH_SAVE_CART)
	public ResponseEntity<ResponseJsonDTO> saveCart(
	        @RequestBody CartDTO cartDTO)
	{
		// TODO controller validations
		cartDTO = cartService.save(cartDTO);
		return ResponseEntity.ok(createSuccessResponseJSON());
	}
}
