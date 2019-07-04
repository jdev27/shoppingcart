/**
 * 
 */
package com.coding.exercise.shoppingcart.dto;

import static com.coding.exercise.shoppingcart.constant.AppConstants.M_D_YYYY_SLASH_PATTERN;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.Transient;

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
public class CartDTO extends VersionPersistentDTO
{

	private String createDate;

	@Transient
	private LocalDate createDt;

	private String refNo;

	private String updateRefNo;

	private Set<CartItemDTO> cartItems;

	public LocalDate getCreateDt()
	{
		if (createDate != null)
		{
			DateTimeFormatter formatter =
			        DateTimeFormatter.ofPattern(M_D_YYYY_SLASH_PATTERN);
			createDt = LocalDate.parse(createDate, formatter);
		}
		return createDt;
	}
}
