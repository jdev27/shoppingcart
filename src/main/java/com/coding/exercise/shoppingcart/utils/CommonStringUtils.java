/**
 * 
 */
package com.coding.exercise.shoppingcart.utils;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author ruben.ortiz
 *
 */
public class CommonStringUtils
{

	private static final Logger logger = getLogger(CommonStringUtils.class);

	private CommonStringUtils()
	{
	}

	/**
	 * Appends Objects
	 * 
	 * @param arg
	 * @return string value of the appended objects
	 */
	public static String appendStrings(Object... arg)
	{
		StringBuilder sb = new StringBuilder();
		for (Object s : arg)
		{
			sb.append(s);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param obj
	 * @return converted String JSON value
	 */
	public static String convertObjectToJsonString(Object obj)
	{
		String resp = null;
		if (obj != null)
		{
			try
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.findAndRegisterModules();
				mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

				resp = mapper.writeValueAsString(obj);
			}
			catch (JsonProcessingException e)
			{
				logger.error(e.getMessage(), e);
			}
		}
		return resp;
	}
}
