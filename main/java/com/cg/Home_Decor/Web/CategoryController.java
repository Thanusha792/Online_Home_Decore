package com.cg.Home_Decor.Web;
/*
 * @author Thanusha
 * Category controller layer.
 */
import com.cg.Home_Decor.service.*;
import com.cg.Home_Decor.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;



@RestController
@RequestMapping("/api")


public class CategoryController {
	
	@Autowired
	private CategoryServiceImple categoryServiceImple;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * this method adds categories to the database
	 * @param object of category 
	 * @param result-object of binding result
	 * @return category and http status
	 */
	@PostMapping("/categories")
	public ResponseEntity<?> createCategory(@Valid @RequestBody Category category,BindingResult result) {
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Category newcategory=categoryServiceImple.saveCategory(category);
		return new ResponseEntity<Category>(newcategory, HttpStatus.CREATED);
	}
	/**
     * this method shows the categorywithrespective to id
     * @param id of category
     * @return category object 
     * @throws CategoryException 
     */
	@GetMapping("categories/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id){
		return new ResponseEntity<Category>(categoryServiceImple.findCategoryById(id),HttpStatus.OK);
	}
	/**
	 * this method returns list of the category
	 * @return list of categories
	 */
	@GetMapping("categories/all")
	public Iterable<Category> getAllCategories(){
		return categoryServiceImple.findAllCategories();
	}
	/**
	 * this method deletes category from data base
	 * @param id of category
	 * @return string 
	 */
	@DeleteMapping("categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id){
		categoryServiceImple.deleteCategoryById(id);
		return new ResponseEntity<String> ("Category with Id : "+id+" Deleted!",HttpStatus.OK);
	}

}
