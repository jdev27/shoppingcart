/**
 * 
 */
package com.coding.exercise.shoppingcart.domain;

import static javax.persistence.FetchType.LAZY;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
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
@Table(name = "CART")
@SuperBuilder
@NoArgsConstructor
public class CartEntity extends VersionPersistentEntity
{

	@Column(name = "CREATE_DATE")
	private LocalDate createDate;

	@Column(name = "REF_NO")
	private String refNo;

	@Column(name = "UPDT_REF_NO")
	private String updateRefNo;

	@OneToMany(cascade = CascadeType.ALL, fetch = LAZY)
	private Set<CartItemEntity> cartItems;

	@PrePersist
	protected void init()
	{
		if (this.createDate == null)
		{
			this.createDate = LocalDate.now();
		}
	}
}
