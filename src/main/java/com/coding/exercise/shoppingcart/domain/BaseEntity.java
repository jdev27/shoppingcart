/**
 * 
 */
package com.coding.exercise.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author ruben.ortiz
 *
 */
@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class BaseEntity
{

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(
	    name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID", nullable = false)
	private String id;
}
