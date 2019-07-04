/**
 * 
 */
package com.coding.exercise.shoppingcart.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.coding.exercise.shoppingcart.domain.ItemEntity;
import com.coding.exercise.shoppingcart.dto.ItemDTO;
import com.coding.exercise.shoppingcart.mapper.ItemMapper;
import com.coding.exercise.shoppingcart.repository.ItemRepository;

/**
 * @author ruben.ortiz
 *
 */
@Service
public class ItemServiceImpl implements ItemService
{

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<ItemDTO> list()
	{
		return itemRepository.findByDelFalse().stream() //
		        .map(itemMapper::mapToDTO) //
		        .collect(Collectors.toList());
	}

	@Override
	public Page<ItemDTO> listPages(Boolean getAll, int pageNumber, int size)
	{

		PageRequest pageReq = null;
		if (!getAll)
		{
			pageReq = gotoPage(pageNumber, size);
		}
		return itemRepository.findByDel(false, pageReq)
		        .map(itemMapper::mapToDTO);
	}

	private PageRequest gotoPage(int page, int size)
	{
		PageRequest request =
		        PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
		return request;
	}

	@Override
	public ItemDTO save(ItemDTO dto)
	{
		ItemEntity entity = itemMapper.mapToEntity(dto);
		entity = itemRepository.save(entity);
		return itemMapper.mapToDTO(entity);
	}
}
