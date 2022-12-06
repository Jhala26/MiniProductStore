package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {

	public Product addingProduct(Product product,String key) throws ProductException, LoginException;
	
	public Product updatingProduct(Product product,String key) throws ProductException,LoginException;
	
	public Product deletingProduct( Integer productId,String key) throws ProductException, LoginException;
	
	public Product viewProductById(Integer productId,String key) throws ProductException,LoginException;
	
	public List<Product> viewAllProducts(String key) throws ProductException,LoginException;
	
}
