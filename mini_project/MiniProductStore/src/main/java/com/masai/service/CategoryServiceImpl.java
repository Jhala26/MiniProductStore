package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Category;
import com.masai.model.User;
import com.masai.model.runningUserSession;
import com.masai.repository.CategoryDao;
import com.masai.repository.RunningSessionDao;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao cDao;
	
	@Autowired
	private RunningSessionDao rDao;
	

	@Override
	public Category addCategory(Category category, String key) throws CategoryException, LoginException {
		
		
		runningUserSession logInUser = rDao.findByUuid(key);
		
		if(logInUser == null) {
			
			throw new LoginException("Please provide a valid key.");
			
		}
		
		if(logInUser.getType() == "Admin") {
			
			Category cat = cDao.findByType(category.getCategoryType());
			
			if(cat != null) {
				
				throw new CategoryException("Category is already present");
			}
			
			return cDao.save(category);
			
			
		}
		else {
			throw new LoginException("Not a Authorised user");
		}
		
	}

	@Override
	public Category updateCategory(Category category, String key) throws CategoryException, LoginException {
		
		runningUserSession logInUser = rDao.findByUuid(key);
		
		if(logInUser == null) {
			
			throw new LoginException("Please provide a valid key.");
			
		}
		
		if(logInUser.getType() == "Admin") {
			
			Category cat = cDao.findById(category.getCategoryId()).orElseThrow(() -> new CategoryException("Category with Id "+ category.getCategoryId() + "does not exist"));
			
			if(category.getCategoryType() != null) cat.setCategoryType(category.getCategoryType());
			if(category.getProductList() != null) cat.setProductList(category.getProductList());
			
			
			return cDao.save(cat);
			
		}
		else {
			throw new LoginException("Not a Authorised user");
		}
		
		
	}
	
	

	@Override
	public Category deleteCategory(Integer categoryId, String key) throws CategoryException, LoginException {
		
		runningUserSession logInUser = rDao.findByUuid(key);
		
		if(logInUser == null) {
			
			throw new LoginException("Please provide a valid key.");
			
		}
		
		if(logInUser.getType() == "Admin") {
			
			Category cat = cDao.findById(categoryId).orElseThrow(() -> new CategoryException("Category with Id "+ categoryId + "does not exist"));
			
			cDao.delete(cat);
			
			
			return cat;
			
		}
		else {
			throw new LoginException("Not a Authorised user");
		}
		
		
	}

	@Override
	public Category viewCategory(Integer categoryId, String key) throws CategoryException, LoginException {
		
		runningUserSession logInUser = rDao.findByUuid(key);
		
		if(logInUser == null) {
			
			throw new LoginException("Please provide a valid key.");
			
		}
		
		if(logInUser.getType() == "Admin") {
			
			Category cat = cDao.findById(categoryId).orElseThrow(() -> new CategoryException("Category with Id "+ categoryId + "does not exist"));
			
			
			return cat;
			
		}
		else {
			throw new LoginException("Not a Authorised user");
		}
		
		
	}

	@Override
	public List<Category> viewAllCategory(String key) throws CategoryException, LoginException {
		
		
		runningUserSession logInUser = rDao.findByUuid(key);
		
		if(logInUser == null) {
			
			throw new LoginException("Please provide a valid key.");
			
		}
		
		if(logInUser.getType() == "Admin") {
			
			List<Category> cat = cDao.findAll();
			
			if(cat.size() != 0 ) {
				
				return cat;
				
			}
			else {
				throw new CategoryException("No Category found...!");
			}
			
		}
		else {
			throw new LoginException("Not a Authorised user");
		}
		
		
	}

}
