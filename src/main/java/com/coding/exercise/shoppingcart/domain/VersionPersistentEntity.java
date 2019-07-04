/**
 * 
 */
package com.coding.exercise.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import com.coding.exercise.shoppingcart.converter.NumericBooleanSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class VersionPersistentEntity extends BaseEntity
{

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version;

	@JsonSerialize(using = NumericBooleanSerializer.class)
	@Column(name = "DEL", nullable = false)
	private Boolean del;

	public Boolean isDeleted()
	{
		return del;
	}

	@PrePersist
	protected void init()
	{
		if (this.del == null)
		{
			this.del = false;
		}
	}
}
