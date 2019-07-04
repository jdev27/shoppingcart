/**
 * 
 */
package com.coding.exercise.shoppingcart.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.coding.exercise.shoppingcart.domain.ItemEntity;

/**
 * @author ruben.ortiz
 *
 */
public interface ItemRepository
        extends
            PagingAndSortingRepository<ItemEntity, String>
{

	List<ItemEntity> findByDelFalse();

	Page<ItemEntity> findByDel(Boolean del, Pageable page);
}
