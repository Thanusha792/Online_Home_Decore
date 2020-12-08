package com.cg.Home_Decor.Domain;

/*
 * @author Thanusha
 * Category entity for category table.
 */
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="Category")
public class Category {
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int categoryId;
	@NotBlank(message="CategoryName is required")
	private String categoryName;
	
	//private Product product;
	//public Product getProduct() {
		//return product;
	//}
	//public void setProduct(Product product) {
	//	this.product = product;
	//}
	
	/*
	 * returns categoryId.
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/*
	 * sets categoryid
	 * @param CatgoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/*
	 * returns category name.
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/*
	 * sets category name.
	 * @param category name.
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
} 


