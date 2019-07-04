/**
 * 
 */
package com.coding.exercise.shoppingcart.domain;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name = "CART_ITEM")
@SuperBuilder
@NoArgsConstructor
public class CartItemEntity extends VersionPersistentEntity
{

	@ManyToOne(cascade = CascadeType.ALL, fetch = LAZY)
	private ItemEntity item;

	@Column(name = "QUANTITY")
	private Integer quantity;
}
