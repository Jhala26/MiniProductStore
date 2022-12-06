package com.masai.service;

import java.util.List;

import com.masai.exception.CategoryException;
import com.masai.exception.LoginException;
import com.masai.model.Category;

public interface CategoryService {

	public Category addCategory(Category category,String key) throws CategoryException, LoginException;
	
	public Category updateCategory(Category category,String key) throws CategoryException,LoginException;
	
	public Category deleteCategory( Integer categoryId,String key) throws CategoryException, LoginException;
	
	public Category viewCategory(Integer categoryId,String key) throws CategoryException,LoginException;
	
	public List<Category> viewAllCategory(String key) throws CategoryException,LoginException;
	
	
}
