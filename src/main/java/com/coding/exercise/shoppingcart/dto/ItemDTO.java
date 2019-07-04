/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

import java.math.BigDecimal;

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
@NoArgsConstructor
public class ItemDTO extends VersionPersistentDTO
{

	private String name;

	private String description;

	private BigDecimal amount;

	private String refNo;

	private String updateRefNo;

}
