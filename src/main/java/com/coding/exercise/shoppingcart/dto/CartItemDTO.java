/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author ruben.ortiz
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO extends VersionPersistentDTO
{

	private ItemDTO item;

	private Integer quantity;
}
