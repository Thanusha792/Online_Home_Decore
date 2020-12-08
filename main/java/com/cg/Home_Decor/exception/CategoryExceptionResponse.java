package com.cg.Home_Decor.exception;
/*
 * CategoryExceptionResponse to handle exception
 * @author Thanusha
 */
public class CategoryExceptionResponse {
	
	private String categoryId;

	public CategoryExceptionResponse(String id) {
		super();
		this.categoryId = categoryId;
	}

	public String geCategoryId() {
		return categoryId;
	}

	public void setcategoryId(String categoryId) {
		this.categoryId= categoryId;
	}

}
