package com.cg.Home_Decor.repository;

/**
 * Testing class for Category Repository.
 * @author Thanusha
 *
 */
import org.junit.Assert;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.Home_Decor.Domain.*;
@RunWith(SpringRunner.class)
@DataJpaTest

public class TestCategoryRepository {

	@Autowired
	private  CategoryRepository categoryRepository;
	/**
	 * this method tests the findCategoryById method 
	 * 
	 */
	@Test
	public void testFindByCategoryId(){
		
	   
		Category category=new Category();
		category.setCategoryId(101);
		category.setCategoryName("Kitchen");
		categoryRepository.save(category);
		Assert.assertNotNull(categoryRepository.findByCategoryId(101));
	}
}
