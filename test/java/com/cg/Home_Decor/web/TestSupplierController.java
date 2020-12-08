package com.cg.Home_Decor.web;
/*
 * This class tests the controller layer for supplier class
 * @author Thanusha.
 */
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.Home_Decor.Domain.*;
import com.cg.Home_Decor.repository.*;
import com.cg.Home_Decor.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

import com.cg.Home_Decor.Web.*;
/**
 * class tests methods of Supplier controller class
 * @author Thanusha
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = SupplierController.class)
@AutoConfigureMockMvc

public class TestSupplierController {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private SupplierRepository supplierRepository;
	@MockBean
	private SupplierServiceImple supplierService;
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * method tests the save Supplier operation
	 * @throws Exception
	 */
	@Test
	public void testSaveSupplier() throws Exception{
	    String URI = "/api/suppliers";
	    
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
	    String jsonInput = this.converttoJson(supplier);
	    Mockito.when(supplierService.saveSupplier(Mockito.any(Supplier.class))).thenReturn(supplier);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * method tests the update Supplier operation
	 * @throws Exception
	 */
	@Test
	public void testUpdateSupplier() throws Exception {
		String uri = "/api/suppliers/{id}";
		
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
				String jsonInput=this.converttoJson(supplier);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(uri,1)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonInput)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
		  Assert.assertEquals(200, mvcResult.getResponse().getStatus());
	}
	/**
	 * method tests to find Supplier by id operation
	 * @throws Exception
	 */
	@Test
	public void testSupplierById() throws Exception {
		String URI= "/api/suppliers/{id}";
		
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
		
        String jsonInput = this.converttoJson(supplier);
        Mockito.when(supplierService.findSupplierById(1)).thenReturn(supplier);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * method tests the lists all the suppliers operation
	 * @throws Exception
	 */
	@Test
	public void testGetAllSuppliers() throws Exception {
		String URI = "/api/suppliers/all";
		
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
		
		
		Supplier supplier1=new Supplier();
		supplier1.setSupplierId(1);
		supplier1.setSupplierName("thanusha");
		supplier1.setSupplierEmail("thanu@gmail.com");
		supplier1.setSupplierPhone("123");
		
		List<Supplier> supplierList = new ArrayList<>();
        supplierList.add(supplier);
        supplierList.add(supplier1);
	    String jsonInput = this.converttoJson(supplierList);
        Mockito.when(supplierService.findAllSuppliers()).thenReturn(supplierList);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/**
	 * method tests the delete operation on supplier
	 * @throws Exception
	 */
	@Test
	public void testDeleteCart() throws Exception {
		String URI = "/api/suppliers/{id}";
		
		Supplier supplier1=new Supplier();
		supplier1.setSupplierId(1);
		supplier1.setSupplierName("thanusha");
		supplier1.setSupplierEmail("thanu@gmail.com");
		supplier1.setSupplierPhone("123");
		
		 String jsonInput=this.converttoJson(supplier1);
		  Mockito.when(supplierService.findSupplierById(1)).thenReturn(supplier1);
		  Mockito.when(supplierService.deleteSupplierById(1)).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI,1).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonOutput).isEqualTo("Supplier with Id : 1 Deleted!");
	}
	/**
	 * this method converts given object data to json format
	 * @param Supplier
	 * @return string
	 * @throws JsonProcessingException
	 */
	private String converttoJson(Object supplier) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(supplier);
	}

}
