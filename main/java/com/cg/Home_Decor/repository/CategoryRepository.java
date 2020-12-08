package com.cg.Home_Decor.repository;
/*
 * Interface CategoryRepository for performing crud operations.
 * @author Thanusha
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.Home_Decor.Domain.*;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
    
	public Category findByCategoryId(int id);
}
