package com.cg.Home_Decor.service;
/*
 * Interface SupplierService   for performing crud operations.
 * @author Thanusha
 */
import com.cg.Home_Decor.Domain.Supplier;

public interface SupplierService {

	public Supplier saveSupplier(Supplier supplier);
	
	public Supplier findSupplierById(int id) ;
	public Iterable<Supplier> findAllSuppliers();
	
	public boolean deleteSupplierById(int id);
	
	 public Supplier updateSupplier(Supplier supplier, int id);

}
