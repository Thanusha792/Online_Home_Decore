package com.cg.Home_Decor.repository;
/*
 * Interface SupplierRepository for performing crud operations.
 * @author Thanusha
 */
import org.springframework.data.repository.CrudRepository;
import com.cg.Home_Decor.Domain.Supplier;
import org.springframework.stereotype.Repository;

@Repository 
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {

	public Supplier findBySupplierId(int id);
	
}
