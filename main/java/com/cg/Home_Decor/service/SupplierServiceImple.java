
package com.cg.Home_Decor.service;
/*
 * This class provides services for Supplier .
 * @author Thanusha
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.Home_Decor.exception.*;

import com.cg.Home_Decor.Domain.*;
import com.cg.Home_Decor.repository.*;
@Service
public class SupplierServiceImple implements SupplierService {
	private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImple.class);
	
	@Autowired
	private SupplierRepository supplierRepository;
	/**
	 * this method adds a Supplier to database
	 * @param supplier which we want to add
	 * @return supplier
	 */
	public Supplier saveSupplier(Supplier supplier) {
		
		return supplierRepository.save(supplier);
	}
	/**
	 * this method shows supplier which has given id
	 * @param Id of supplier to be shown
	 * @return supplier
	 * @throws SupplierException
	 * */
	public Supplier findSupplierById(int id) {
		
		Supplier supplier = supplierRepository.findBySupplierId(id);
		if (supplier == null) {
			logger.error("Supplier Id " + id + " not available");
			throw new SupplierException("Supplier Id " + id + " not available");
		}
		return supplier;

	}
	/**
     * this method shows all suppliers present in the database
     * @return list of suppliers
     */
	public Iterable<Supplier> findAllSuppliers(){
		return supplierRepository.findAll();
	}
	/**
	 * this method deletes a suppliers from database
	 * @param Id of suppliers to be deleted
	 * @throws SupplierException
	 */
	public boolean deleteSupplierById(int id) {
		Supplier supplier=findSupplierById(id);
		if(supplier==null) {
			logger.error("Supplier Id " + id + " not available");
			throw new SupplierException("Supplier Id" + id + " not available");
		}
		supplierRepository.delete(supplier);
		return true;
	}
	/**
	 * this method updates a supplier to database		
	 * @param supplier,id to be updated
	 * @return supplier
	 * @throws SupplierException 
	 */
	 public Supplier updateSupplier(Supplier supplier, int id) { 
		  Supplier fetchedSupplier=supplierRepository.findBySupplierId(id);
		  if(fetchedSupplier!=null) {
		 fetchedSupplier.setSupplierName(supplier.getSupplierName());
		 fetchedSupplier.setSupplierEmail(supplier.getSupplierEmail());
		 fetchedSupplier.setSupplierPhone(supplier.getSupplierPhone());
		  return supplierRepository.save(fetchedSupplier);
		  }
		  else {
			  logger.error("Unable to find supplier for given id ");
				throw new SupplierException("Unable to find supplier for given id ");
			}
		  }

}
