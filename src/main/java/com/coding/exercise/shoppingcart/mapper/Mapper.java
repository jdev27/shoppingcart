/**
 * 
 */
package com.coding.exercise.shoppingcart.mapper;

/**
 * @author ruben.ortiz
 *
 */
public interface Mapper<ENTITY, DTO>
{

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public ENTITY mapToEntity(DTO dto);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public DTO mapToDTO(ENTITY entity);
}
