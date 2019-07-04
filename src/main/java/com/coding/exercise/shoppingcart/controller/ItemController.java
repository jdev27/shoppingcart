/**
 * 
 */
package com.coding.exercise.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.exercise.shoppingcart.dto.CommonResponseDTO;
import com.coding.exercise.shoppingcart.dto.ItemDTO;
import com.coding.exercise.shoppingcart.service.ItemService;

/**
 * @author ruben.ortiz
 *
 */
@RestController
public class ItemController extends BaseController
{

	private static final String PATH_LIST = "list";

	private static final String PATH_LIST_PAGES = "listpages";

	@Autowired
	private ItemService itemService;

	@GetMapping(PATH_LIST)
	public ResponseEntity<CommonResponseDTO<List<ItemDTO>>> taskList()
	{
		List<ItemDTO> list = itemService.list();
		return ResponseEntity.ok(createCommonResponse(list));
	}

	@GetMapping(PATH_LIST_PAGES)
	public ResponseEntity<CommonResponseDTO<Page<ItemDTO>>> taskListPageable(
	        @RequestParam(
	            name = "getAll", defaultValue = "true") Boolean getAll,
	        @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
	        @RequestParam(name = "size", defaultValue = "1") Integer size)
	{
		Page<ItemDTO> list = itemService.listPages(getAll, pageNum, size);
		return ResponseEntity.ok(createCommonResponse(list));
	}

}
