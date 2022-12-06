package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CategoryException;
import com.masai.exception.LoginException;
import com.masai.model.Category;
import com.masai.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cService;
	
	
	
	
	@PostMapping("/category")
    public ResponseEntity<Category> addCategoryHandler(@Valid @RequestBody Category category,@RequestParam String key) throws CategoryException, LoginException {
		
		Category c = cService.addCategory(category,key);
		
		return new ResponseEntity<Category>(c, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/category")
	public ResponseEntity<Category> updateCategoryHandler( @Valid @RequestBody Category category,@RequestParam String key) throws CategoryException, LoginException{
		
		Category c = cService.updateCategory(category,key);
		
		return new ResponseEntity<Category>(c, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Category> viewCategoryHandler(@PathVariable("categoryId") Integer categoryId,@RequestParam String key) throws CategoryException, LoginException {
		
		Category c = cService.viewCategory(categoryId,key);
		
		return new ResponseEntity<Category>(c, HttpStatus.FOUND);
	}
	
	
	@GetMapping("/viewAllCategory")
	public ResponseEntity<List<Category>> viewAllCategoryHandler(@RequestParam String key) throws LoginException, CategoryException{
		
		List<Category> c = cService.viewAllCategory(key);
		
		return new ResponseEntity<List<Category>>(c, HttpStatus.FOUND);
	}
	
	
	
}
