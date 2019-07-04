/**
 * 
 */
package com.coding.exercise.shoppingcart.converter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author ruben.ortiz
 *
 */
public class NumericBooleanSerializer extends JsonSerializer<Boolean>
{

	private static final int TRUE_NUMERIC_VALUE = 1;

	private static final int FALSE_NUMERIC_VALUE = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object,
	 * com.fasterxml.jackson.core.JsonGenerator,
	 * com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Boolean bool, JsonGenerator generator,
	        SerializerProvider provider) throws IOException
	{
		generator.writeNumber(bool ? TRUE_NUMERIC_VALUE : FALSE_NUMERIC_VALUE);
	}
}