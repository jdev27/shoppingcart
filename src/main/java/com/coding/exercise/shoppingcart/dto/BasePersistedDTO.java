/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author ruben.ortiz
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BasePersistedDTO
{

	private String id;
}
