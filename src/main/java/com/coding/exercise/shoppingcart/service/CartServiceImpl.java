/**
 * 
 */
package com.coding.exercise.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.exercise.shoppingcart.domain.CartEntity;
import com.coding.exercise.shoppingcart.dto.CartDTO;
import com.coding.exercise.shoppingcart.mapper.CartMapper;
import com.coding.exercise.shoppingcart.repository.CartRepository;

/**
 * @author ruben.ortiz
 *
 */
@Service
public class CartServiceImpl implements CartService
{

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartMapper cartMapper;

	@Override
	public CartDTO save(CartDTO dto)
	{
		// TODO add service validations
		CartEntity entity = cartMapper.mapToEntity(dto);
		entity = cartRepository.save(entity);
		return cartMapper.mapToDTO(entity);
	}
}
