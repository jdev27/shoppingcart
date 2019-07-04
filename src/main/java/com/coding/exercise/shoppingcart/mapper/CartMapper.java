/**
 * 
 */
package com.coding.exercise.shoppingcart.mapper;

import static com.coding.exercise.shoppingcart.constant.AppConstants.M_D_YYYY_SLASH_PATTERN;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coding.exercise.shoppingcart.domain.CartEntity;
import com.coding.exercise.shoppingcart.domain.CartItemEntity;
import com.coding.exercise.shoppingcart.dto.CartDTO;
import com.coding.exercise.shoppingcart.dto.CartItemDTO;

/**
 * @author ruben.ortiz
 *
 */
@Component
public class CartMapper implements Mapper<CartEntity, CartDTO>
{

	@Autowired
	private CartItemMapper cartItemMapper;

	@Override
	public CartEntity mapToEntity(CartDTO dto)
	{
		CartEntity entity = null;

		Set<CartItemEntity> cartItems = new HashSet<>();
		Set<CartItemDTO> cartItemDTOs = dto.getCartItems();

		for (CartItemDTO cartItemDTO : SetUtils.emptyIfNull(cartItemDTOs))
		{
			cartItems.add(cartItemMapper.mapToEntity(cartItemDTO));
		}
		if (dto != null)
		{
			entity = CartEntity.builder() //
			        .id(dto.getId()) //
			        .version(dto.getVersion()) //
			        .del(dto.getDel()) //
			        .createDate(dto.getCreateDt()) //
			        .refNo(dto.getRefNo()) //
			        .updateRefNo(dto.getUpdateRefNo()) //
			        .cartItems(cartItems) //
			        .build();
		}
		return entity;
	}

	@Override
	public CartDTO mapToDTO(CartEntity entity)
	{
		CartDTO dto = null;
		LocalDate createDate = entity.getCreateDate();
		String formatDateTime = null;
		if (createDate != null)
		{
			DateTimeFormatter formatter =
			        DateTimeFormatter.ofPattern(M_D_YYYY_SLASH_PATTERN);
			formatDateTime = entity.getCreateDate().format(formatter);

		}
		Set<CartItemDTO> cartItemDTOs = new HashSet<>();
		Set<CartItemEntity> cartItems = entity.getCartItems();

		for (CartItemEntity cartItemDTO : SetUtils.emptyIfNull(cartItems))
		{
			cartItemDTOs.add(cartItemMapper.mapToDTO(cartItemDTO));
		}

		if (entity != null)
		{
			dto = CartDTO.builder() //
			        .id(entity.getId()) //
			        .version(entity.getVersion()) //
			        .del(entity.getDel()) //
			        .createDate(formatDateTime) //
			        .refNo(entity.getRefNo()) //
			        .updateRefNo(entity.getUpdateRefNo()) //
			        .cartItems(cartItemDTOs) //
			        .build();
		}
		return dto;
	}

}
