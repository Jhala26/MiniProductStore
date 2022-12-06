package com.masai.service;

import java.util.List;

import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {

	public User addingUser(User user) throws UserException;
	
	public User updatingUser(User user,String key) throws UserException;
	
	public User deletingUser(Integer userId,String key) throws UserException;
	
	public User viewUserById(Integer userId,String key) throws UserException;
	
	public List<User> viewAllUsers(String key) throws UserException;
	
}
