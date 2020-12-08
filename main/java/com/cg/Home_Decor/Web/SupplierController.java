package com.cg.Home_Decor.Web;
/*
 * @author Thanusha
 * Supplier controller layer.
 */
import com.cg.Home_Decor.service.*;
import com.cg.Home_Decor.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")

public class SupplierController {
	
	@Autowired
	private SupplierServiceImple supplierservice;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * this method adds supplier to the database
	 * @param object of supplier 
	 * @param result-object of binding result
	 * @return supplier and http status
	 */
	@PostMapping("/suppliers")
	public ResponseEntity<?> createSupplier(@Valid @RequestBody Supplier supplier,BindingResult result) {
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Supplier newsupplier=supplierservice.saveSupplier(supplier);
		return new ResponseEntity<Supplier>(newsupplier, HttpStatus.CREATED);
	}
	/**
     * this method shows the supplierwithrespective to id
     * @param id of supplier
     * @return supplier object 
     * @throws SupplierException 
     */
	@GetMapping("/suppliers/{id}")
	public ResponseEntity<?> getSupplierById(@PathVariable int id){
		return new ResponseEntity<Supplier>(supplierservice.findSupplierById(id),HttpStatus.OK);
	}
	/**
	 * this method returns list of the supplier
	 * @return list of suppliers
	 */
	@GetMapping("/suppliers/all")
	public Iterable<Supplier> getAllSuppliers(){
		return supplierservice.findAllSuppliers();
	}
	/**
	 * this method deletes suppliers from data base
	 * @param id of suppliers
	 * @return string 
	 */

	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<?> deleteSupplier(@PathVariable int id){
		supplierservice.deleteSupplierById(id);
		return new ResponseEntity<String> ("Supplier with Id : "+id+" Deleted!",HttpStatus.OK);
	}
	/**
	 * this method updates Supplier in to data base
	 * @param id of supplier
	 * @param supplier object to be updated 
	 * @return string
	 *  
	 */
	@PutMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier ,@PathVariable int id) {
		Supplier updatedSupplier=supplierservice.updateSupplier(supplier, id);
		return new ResponseEntity<Supplier>(updatedSupplier,HttpStatus.OK);
		
	}
}
