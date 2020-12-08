package com.cg.Home_Decor.exception;
/*
 * Exception class to handle Supplier exceptions occureded in service layer.
 * @author Thanusha
 */
public class SupplierExceptionResponse {

	
	private String supplierId;
	/*
	 * Constructor of Supplier Exception class.
	 */

	public SupplierExceptionResponse(String id) {
		super();
		this.supplierId = supplierId;
	}

	public String getSupplierId() {
		return supplierId;
	}
	/*
     * @param Constructor for Supplier Exception class.
     */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
}
