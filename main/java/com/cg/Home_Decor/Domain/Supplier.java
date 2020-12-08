package com.cg.Home_Decor.Domain;

/*
 * @author Thanusha
 * Entity class for the supplier table .
 */
import javax.persistence.Entity;
import javax.persistence.Embedded;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Supplier {
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	@Id
	private int supplierId;
	
	@NotBlank(message="Name is required")
	private String supplierName;
	
	@NotBlank(message="mail is required")
	private String supplierEmail;
	
	@NotBlank(message="Phone number is required ")
	private String supplierPhone;
	

	
		
	public Supplier() {
		
	}
		public Supplier(int supplierId, @NotBlank(message = "Name is required") String supplierName,
			@NotBlank(message = "mail is required") String supplierEmail,
			@NotBlank(message = "Phone number is required ") String supplierPhone)
		 
		{
				this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierEmail = supplierEmail;
		this.supplierPhone = supplierPhone;
		
	}
		

	public int getSupplierId() {
		return supplierId;
	}
	/*
	 * @param supplier id is set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	/*
	 * returns supplier name
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/*
	 * @param supplier name is created in object.
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/*
	 * returns supplier email address.
	 */
	public String getSupplierEmail() {
		return supplierEmail;
	}
	/*
	 * @param supplier email is created in object.
	 */
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	/*
	 * returns supplier phone number.
	 */
	public String getSupplierPhone() {
		return supplierPhone;
	}
	/*
	 * @param supplier phone is created in object.
	 */
	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}
	
	

}

