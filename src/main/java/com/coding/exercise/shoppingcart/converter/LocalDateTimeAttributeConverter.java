/**
 * 
 */
package com.coding.exercise.shoppingcart.converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author ruben.ortiz
 *
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter
        implements
            AttributeConverter<LocalDateTime, Timestamp>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime)
	{
		return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp)
	{
		return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
	}
}
