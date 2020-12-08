 package com.cg.Home_Decor.service;
/*
 * This class is responsible for validating the input.
 * @author Thanusha
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.*;

@Service 
public class MapValidationErrorService {
	/*
	 * This method validates the input and binds the result into map.
	 * @Param binding result.
	 * @returns responseEntity map.
	 */
	public ResponseEntity<?> mapValidationError(BindingResult result) {
		
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError fieldError :  result.getFieldErrors()) {
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		return null;
	}	

}
