package com.cg.Home_Decor.repository;

/**
 * Testing class for Supplier Repository.
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

public class TestSupplierRepository {
	@Autowired
	private  SupplierRepository supplierRepository;
	/**
	 * this method tests the findSupplierById method 
	 * 
	 */
	@Test
	public void testFindBySupplierId(){
		
		//Address address=new Address("mithra homes","hyd","TS","India");
		Supplier supplier=new Supplier(1,"Thanusha","Thanu@gmail.com","1234");
		supplierRepository.save(supplier);
		Assert.assertNotNull(supplierRepository.findBySupplierId(1));
	}

}
