package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductController {

	
	private ProductService pService;
	
	
	
	@PostMapping("/addProduct")
    public ResponseEntity<Product> addingProductHandler(@Valid @RequestBody Product product,@RequestParam String key) throws ProductException, LoginException{
		
		Product pro = pService.addingProduct(product,key);
		
		return new ResponseEntity<Product>(pro, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updatingProductHandler( @Valid @RequestBody Product product,@RequestParam String key) throws ProductException, LoginException{
		
		Product pro = pService.updatingProduct(product,key);
		
		return new ResponseEntity<Product>(pro, HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<Product> deletingProductHandler(@PathVariable("productId") Integer productId,@RequestParam String key) throws ProductException, LoginException{
		
		Product pro = pService.deletingProduct(productId,key);
		
		return new ResponseEntity<Product>(pro, HttpStatus.FOUND);
	}
	
	
	@GetMapping("/viewProduct/{productId}")
	public ResponseEntity<Product> viewProductByIdHandler(@PathVariable("productId") Integer productId,@RequestParam String key) throws ProductException, LoginException{
		
		Product pro = pService.viewProductById(productId,key);
		
		return new ResponseEntity<Product>(pro, HttpStatus.FOUND);
	}
	
	
	
	@GetMapping("/viewAllProduct")
	public ResponseEntity<List<Product>> viewAllProductHandler(@RequestParam String key) throws ProductException, LoginException{
		
		List<Product> pro = pService.viewAllProducts(key);
		
		return new ResponseEntity<List<Product>>(pro, HttpStatus.FOUND);
	}
	
	
}
