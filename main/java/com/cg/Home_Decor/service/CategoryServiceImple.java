package com.cg.Home_Decor.service;
/*
 * This class provides services for Category .
 * @author Thanusha
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.Home_Decor.Domain.Category;
import com.cg.Home_Decor.exception.CategoryException;
import com.cg.Home_Decor.repository.CategoryRepository;


@Service 
public class CategoryServiceImple implements CategoryService{
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImple.class);
	@Autowired
	private CategoryRepository categoryRepository;
	/**
	 * this method adds a category to database
	 * @param category which we want to add
	 * @return category
	 */
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	/**
	 * this method shows category which has given id
	 * @param categoryId of category to be shown
	 * @return category
	 * @throws CategoryException
	 */	
	public Category findCategoryById(int id) {
		Category category= categoryRepository.findByCategoryId(id);
		try{
			if (category == null) {
			logger.error("Category Id " + id + " not available");
			throw new CategoryException("Category Id " + id + " not available");
		}
		}catch(CategoryException e) {
			logger.info(e.getMessage());
		}
		return category;

	}
	/**
     * this method shows all categories present in the database
     * @return list of categories
     */
	public Iterable<Category> findAllCategories(){
		return categoryRepository.findAll();
	}
	/**
	 * this method deletes a category from database
	 * @param categoryId of category to be deleted
	 * @throws CategoryException
	 * @returns 
	 */
	public boolean deleteCategoryById(int id) {
		Category category=findCategoryById(id);
		try {
		if(category==null) {
			logger.error("Category Id " + id + " not available");
			throw new CategoryException("Category Id" + id + " not available");
		}
		}catch(CategoryException e) {
			logger.info(e.getMessage());
		}
		categoryRepository.delete(category);
		return true;
	}

}
