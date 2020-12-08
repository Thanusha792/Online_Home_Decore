package com.cg.Home_Decor.service;
/*
 * Interface CategoryService   for performing crud operations.
 * @author Thanusha
 */

import com.cg.Home_Decor.Domain.Category;
public interface CategoryService {
	
	
	public Category saveCategory(Category category);
	
	public Category findCategoryById(int id);
	public Iterable<Category> findAllCategories();
	
	public boolean deleteCategoryById(int id);


}
