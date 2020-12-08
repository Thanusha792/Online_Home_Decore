package com.cg.Home_Decor.web;
/*
 * This class tests the controller layer for categories class
 * @author Thanusha.
 */
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.cg.Home_Decor.Domain.Category;
import com.cg.Home_Decor.Domain.Supplier;
import com.cg.Home_Decor.repository.CategoryRepository;
import com.cg.Home_Decor.service.CategoryServiceImple;
import com.cg.Home_Decor.service.MapValidationErrorService;
import com.cg.Home_Decor.service.SupplierService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.cg.Home_Decor.Web.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CategoryController.class)
@AutoConfigureMockMvc
public class TestCategoryController {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private CategoryRepository categoryRepository;
	@MockBean
	private CategoryServiceImple categoryService;
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	@Test
	/**
	 * method tests the save Category operation
	 * @throws Exception
	 */
	public void testSaveCategory() throws Exception{
	    String URI = "/api/categories";
	    Category category=new Category();
	    category.setCategoryId(101);
	    category.setCategoryName("Kitchen");
	    String jsonInput = this.converttoJson(category);
	    Mockito.when(categoryService.saveCategory(Mockito.any(Category.class))).thenReturn(category);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
	    
	    int status=mvcResult.getResponse().getStatus(); 
       Assert.assertEquals(HttpStatus.CREATED.value(), status);
       
	}
	/**
	 * method tests to find Category by id operation
	 * @throws Exception
	 */
	@Test
	public void testCategoryById() throws Exception {
		String URI= "/api/categories/{id}";
		Category category=new Category();
	    category.setCategoryId(101);
	    category.setCategoryName("Kitchen");
        String jsonInput = this.converttoJson(category);
        Mockito.when(categoryService.findCategoryById(101)).thenReturn(category);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * method tests the lists all the categories operation
	 * @throws Exception
	 */
	@Test
	public void testViewAllCategories() throws Exception {
		 
		 String uri="/api/categories/all";
		 Category category=new Category();
		    category.setCategoryId(101);
		    category.setCategoryName("Kitchen");
		  
		    Category category1=new Category();
		    category1.setCategoryId(102);
		    category1.setCategoryName("furniture");
		  
		  List<Category> categoryList=new ArrayList<Category>(); 
		  categoryList.add(category);
		  categoryList.add(category1);		  
		  String jsonInput = this.converttoJson(categoryList);
	        Mockito.when(categoryService.findAllCategories()).thenReturn(categoryList);
		    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		    String jsonOutput = mockHttpServletResponse.getContentAsString();
		    System.out.println(jsonOutput);
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	 }
	/**
	 * method tests the delete operation on Categories
	 * @throws Exception
	 */
	@Test
	public void testDeleteCart() throws Exception {
		String URI = "/api/categories/{id}";
		Category category1=new Category();
	    category1.setCategoryId(102);
	    category1.setCategoryName("furniture");
	    String jsonInput=this.converttoJson(category1);
		  Mockito.when(categoryService.findCategoryById(102)).thenReturn(category1);
		  Mockito.when(categoryService.deleteCategoryById(102)).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI,102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonOutput).isEqualTo("Category with Id : 102 Deleted!");
	}
	private String converttoJson(Object category) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(category);
	}
	
}
