package com.cg.Home_Decor.service;
/**
 * tests the operations on Category.
 * @author Thanusha
 *
 */
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.Home_Decor.Domain.*;
import com.cg.Home_Decor.exception.*;
import com.cg.Home_Decor.repository.*;
@RunWith(SpringRunner.class)
@SpringBootTest

public class TestCategoryService {
	
	@MockBean
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryService categoryService;
	/**
	 * tests the method findByCategoryId
	 * 
	 */
	@Test
	public void testGetCategoryById(){
		Category category=new Category();
		category.setCategoryId(101);
		category.setCategoryName("Kitchen");
		Mockito.when(categoryRepository.findByCategoryId(101)).thenReturn(category);
	    assertThat(categoryService.findCategoryById(101)).isEqualTo(category);
	}
	/**
	 * tests the method findAllCategories 
	 */
	@Test
	public void testSuppliersList() {
		Category category=new Category();
		category.setCategoryId(101);
		category.setCategoryName("Kitchen");
		Category category1=new Category();
		category1.setCategoryId(102);
		category1.setCategoryName("furniture");
		List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        categoryList.add(category1);
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        assertThat(categoryService.findAllCategories()).isEqualTo(categoryList);
	}
	/**
	 * tests the method saveOrUpdate
	 */
	@Test
	public void testSaveCategory() {
		Category category=new Category();
		category.setCategoryId(101);
		category.setCategoryName("Kitchen");
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		assertThat(categoryService.saveCategory(category)).isEqualTo(category);		
	}
	/**
	 * tests the method deleteCategory
	 *  
	 */
	@Test
    public void testDeleteCategory(){
		Category category=new Category();
		category.setCategoryId(101);
		category.setCategoryName("Kitchen");
		categoryRepository.save(category);
		Mockito.when(categoryRepository.findByCategoryId(101)).thenReturn(category);
		categoryService.deleteCategoryById(101);
		Assert.assertTrue(categoryRepository.findById(101) .isEmpty());
	}



}
