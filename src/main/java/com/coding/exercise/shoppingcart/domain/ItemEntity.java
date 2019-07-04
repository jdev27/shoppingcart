/**
 * 
 */
package com.coding.exercise.shoppingcart.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity
@Table(name = "ITEM")
@SuperBuilder
@NoArgsConstructor
public class ItemEntity extends VersionPersistentEntity
{

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "REF_NO")
	private String refNo;

	@Column(name = "UPDT_REF_NO")
	private String updateRefNo;
}
