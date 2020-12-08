package com.cg.Home_Decor.exception;
/*
 * Exception class to handle Category exceptions occureded in service layer.
 * @author Thanusha
 */




public class CategoryException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructor of Category Exception class.
	 */
	public CategoryException() {
		super();
	}
    /*
     * @param Constructor for Category Exception class.
     */
	public CategoryException(String errMsg) {
		super(errMsg);
	}

}
