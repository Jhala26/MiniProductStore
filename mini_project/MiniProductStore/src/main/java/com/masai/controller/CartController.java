package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Cart;
import com.masai.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cService;
	
	
	@PostMapping("/addProduct/{productId}")
	public ResponseEntity<Cart> addNewProductToCartHandler(@Valid @PathVariable("productId") Integer productId, @RequestParam String key) throws ProductException, CartException,UserException{
		
		Cart cart = cService.addNewProductToCart(productId, key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<Cart> deleteProductFromCartHandler(@Valid @PathVariable("productId") Integer productId, @RequestParam String key) throws ProductException, CartException,UserException{
		
		Cart cart = cService.deleteProductFromCart(productId, key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/viewcart")
	public ResponseEntity<Cart> viewCartHandler(@Valid @RequestParam String key) throws CartException,UserException{
		
		Cart cart = cService.viewCart(key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.FOUND);
		
	}
	
	
	
	
}
