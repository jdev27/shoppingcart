/**
 * 
 */
package com.coding.exercise.shoppingcart.mapper;

import org.springframework.stereotype.Component;

import com.coding.exercise.shoppingcart.domain.ItemEntity;
import com.coding.exercise.shoppingcart.dto.ItemDTO;

/**
 * @author ruben.ortiz
 *
 */
@Component
public class ItemMapper implements Mapper<ItemEntity, ItemDTO>
{

	@Override
	public ItemEntity mapToEntity(ItemDTO dto)
	{
		ItemEntity entity = null;
		if (dto != null)
		{
			entity = ItemEntity.builder() //
			        .id(dto.getId()) //
			        .version(dto.getVersion()) //
			        .del(dto.getDel()) //
			        .name(dto.getName()) //
			        .description(dto.getDescription()) //
			        .amount(dto.getAmount()) //
			        .refNo(dto.getRefNo()) //
			        .updateRefNo(dto.getUpdateRefNo()) //
			        .build();
		}
		return entity;
	}

	@Override
	public ItemDTO mapToDTO(ItemEntity entity)
	{
		ItemDTO dto = null;
		if (entity != null)
		{
			dto = ItemDTO.builder() //
			        .id(entity.getId()) //
			        .version(entity.getVersion()) //
			        .del(entity.getDel()) //
			        .name(entity.getName()) //
			        .description(entity.getDescription()) //
			        .amount(entity.getAmount()) //
			        .refNo(entity.getRefNo()) //
			        .updateRefNo(entity.getUpdateRefNo()) //
			        .build();
		}
		return dto;
	}
}
