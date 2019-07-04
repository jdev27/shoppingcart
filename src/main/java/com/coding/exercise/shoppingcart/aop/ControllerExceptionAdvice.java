/****/
package com.coding.exercise.shoppingcart.aop;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.coding.exercise.shoppingcart.dto.ResponseJsonDTO;
import com.coding.exercise.shoppingcart.exception.BaseException;

/**
 * @author ruben.ortiz
 *
 */
@ControllerAdvice
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class ControllerExceptionAdvice extends ResponseEntityExceptionHandler
{

	private static final Logger log =
	        getLogger(ControllerExceptionAdvice.class);

	/**
	 * Handles All BaseSBOLException
	 *
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<ResponseJsonDTO> handleBaseSBOLException(
	        BaseException ex)
	{
		log.error("Error", ex);
		ResponseJsonDTO body = new ResponseJsonDTO(ex.getStatusCode(),
		        ex.getErrorTitle(), ex.getErrorMessage());
		return ResponseEntity.ok(body);
	}

	/**
	 * Handles All Generic Exception
	 *
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ResponseJsonDTO> handleException(Exception e)
	{
		log.error("Error", e);
		ResponseJsonDTO body =
		        new ResponseJsonDTO(500, "Unexpected Error", e.getMessage());
		return ResponseEntity.status(500).body(body);
	}
}
