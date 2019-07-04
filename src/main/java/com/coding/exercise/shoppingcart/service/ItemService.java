/**
 * 
 */
package com.coding.exercise.shoppingcart.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.coding.exercise.shoppingcart.dto.ItemDTO;

/**
 * @author ruben.ortiz
 *
 */
public interface ItemService
{

	/**
	 * 
	 * @return
	 */
	public List<ItemDTO> list();

	/**
	 * 
	 * @param getAll
	 * @param pageNumber
	 * @param size
	 * @return
	 */
	public Page<ItemDTO> listPages(Boolean getAll, int pageNumber, int size);

	public ItemDTO save(ItemDTO dto);
}
