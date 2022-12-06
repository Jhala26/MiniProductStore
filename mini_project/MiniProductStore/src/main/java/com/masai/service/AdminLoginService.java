package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.AdminDTO;
import com.masai.model.AdminDTO;

public interface AdminLoginService {
	public String logIntoAccount(AdminDTO dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}