package com.cg.Home_Decor.exception;
/*
 * Exception class to handle Supplier exceptions occureded in service layer.
 * @author Thanusha
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SupplierException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Constructor of Supplier Exception class.
	 */
	public SupplierException() {
		super();
	}
  
	/*
     * @param Constructor for Supplier Exception class.
     */
	public SupplierException(String errMsg) {
		super(errMsg);
	}
}
