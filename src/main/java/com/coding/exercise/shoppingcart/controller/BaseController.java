/**
 * 
 */
package com.coding.exercise.shoppingcart.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.exercise.shoppingcart.dto.CommonResponseDTO;
import com.coding.exercise.shoppingcart.dto.ResponseJsonDTO;
import com.coding.exercise.shoppingcart.dto.ResponseObjectDTO;

/**
 * @author ruben.ortiz
 *
 */
@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE}, maxAge = 3600)
@RequestMapping(
    value = "api", //
    produces = APPLICATION_JSON_VALUE)
public abstract class BaseController
{

	/**
	 * 
	 * @param data
	 * @return
	 */
	protected <T> CommonResponseDTO<T> createCommonResponse(T data)
	{
		CommonResponseDTO<T> resp = new CommonResponseDTO<>();
		resp.setData(data);
		resp.setResponse(createSuccessResponseObject());
		return resp;
	}

	/**
	 * 
	 * @return
	 */
	protected ResponseObjectDTO createSuccessResponseObject()
	{
		return new ResponseObjectDTO(200);
	}

	/**
	 * 
	 * @return
	 */
	protected ResponseJsonDTO createSuccessResponseJSON()
	{
		return new ResponseJsonDTO(createSuccessResponseObject());
	}
}
