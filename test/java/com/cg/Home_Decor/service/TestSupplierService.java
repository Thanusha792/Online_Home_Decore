package com.cg.Home_Decor.service;

/**
 * tests the operations on Supplier in service layer
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
public class TestSupplierService {
	@MockBean
	private SupplierRepository supplierRepository;
	@Autowired
	private SupplierService supplierService;
	/**
	 * tests the method findBySupplierId
	 * 
	 */
	@Test
	public void testGetSupplierById(){
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
		Mockito.when(supplierRepository.findBySupplierId(1)).thenReturn(supplier);
	    assertThat(supplierService.findSupplierById(1)).isEqualTo(supplier);
	}
	/**
	 *  tests the method updateSuppliers
	 *   @throws SupplierNotFoundException 
	 */
	@Test
	public void testUpdateSupplier() throws SupplierException{
		
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
	
		Mockito.when(supplierRepository.findBySupplierId(1)).thenReturn(supplier);
		Mockito.when(supplierRepository.save(supplier)).thenReturn(supplier);
		assertThat(supplierService.updateSupplier(supplier, 1)).isEqualTo(supplier);		
	}
	/**
	 * tests the method findAllSuppliers 
	 */
	@Test
	public void testSuppliersList() {
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
		
		List<Supplier> supplierList = new ArrayList<>();
        supplierList.add(supplier);
        Mockito.when(supplierRepository.findAll()).thenReturn(supplierList);
        assertThat(supplierService.findAllSuppliers()).isEqualTo(supplierList);
	}
	/**
	 * tests the method saveOrUpdate
	 */
	@Test
	public void testSaveSupplier() {
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
		
		Mockito.when(supplierRepository.save(supplier)).thenReturn(supplier);
		assertThat(supplierService.saveSupplier(supplier)).isEqualTo(supplier);		
	}
	/**
	 * tests the method deleteSuppliers
	 *  
	 */
	@Test
    public void testDeleteSupplier(){
	
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("thanusha");
		supplier.setSupplierEmail("thanu@gmail.com");
		supplier.setSupplierPhone("123");
		
		supplierRepository.save(supplier);
		Mockito.when(supplierRepository.findBySupplierId(1)).thenReturn(supplier);
		supplierService.deleteSupplierById(1);
		Assert.assertTrue(supplierRepository.findById(1) .isEmpty());
	}



}

