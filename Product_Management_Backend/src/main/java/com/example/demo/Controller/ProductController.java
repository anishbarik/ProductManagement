package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product)
	{
		
		
		return new ResponseEntity<>(productservice.saveProduct(product), HttpStatus.CREATED);
/*
* R.BODY Annotation indicating a method parameter should be bound to the body of the web request
*It will convert json data to java object
*/
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllProduct()
	{
		
		return new ResponseEntity<>(productservice.getAllProduct(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id)
	{
		
		return new ResponseEntity<>(productservice.getProductById(id), HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id)
	{
		
		
		return new ResponseEntity<>(productservice.deleteProduct(id) ,HttpStatus.OK);
		
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product ,@PathVariable Integer id)
	{
		return new ResponseEntity<>(productservice.editProduct(product, id) , HttpStatus.CREATED);
		
	}
	

}
