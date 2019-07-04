/**
 * 
 */
package com.coding.exercise.shoppingcart.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coding.exercise.shoppingcart.domain.CartItemEntity;
import com.coding.exercise.shoppingcart.domain.ItemEntity;
import com.coding.exercise.shoppingcart.dto.CartItemDTO;
import com.coding.exercise.shoppingcart.dto.ItemDTO;

/**
 * @author ruben.ortiz
 *
 */
@Component
public class CartItemMapper implements Mapper<CartItemEntity, CartItemDTO>
{

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public CartItemEntity mapToEntity(CartItemDTO dto)
	{
		CartItemEntity entity = null;

		ItemDTO itemDTO = dto.getItem();
		ItemEntity itemEntity = itemMapper.mapToEntity(itemDTO);

		if (dto != null)
		{
			entity = CartItemEntity.builder() //
			        .id(dto.getId()) //
			        .version(dto.getVersion()) //
			        .del(dto.getDel()) //
			        .item(itemEntity) //
			        .quantity(dto.getQuantity()) //
			        .build();
		}
		return entity;
	}

	@Override
	public CartItemDTO mapToDTO(CartItemEntity entity)
	{
		CartItemDTO dto = null;

		ItemEntity itemEntity = entity.getItem();
		ItemDTO itemDTO = itemMapper.mapToDTO(itemEntity);

		if (entity != null)
		{
			dto = CartItemDTO.builder() //
			        .id(entity.getId()) //
			        .version(entity.getVersion()) //
			        .del(entity.getDel()) //
			        .item(itemDTO) //
			        .quantity(entity.getQuantity()) //
			        .build();
		}
		return dto;
	}

}
