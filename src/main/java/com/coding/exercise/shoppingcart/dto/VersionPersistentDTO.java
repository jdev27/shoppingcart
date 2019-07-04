/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

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
public abstract class VersionPersistentDTO extends BasePersistedDTO
{

	private Integer version;

	private Boolean del = false;
}
