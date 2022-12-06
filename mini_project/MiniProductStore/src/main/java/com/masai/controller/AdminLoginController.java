package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.AdminDTO;
import com.masai.service.AdminLoginServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminLoginController {

	@Autowired
	private AdminLoginServiceImpl aService;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> adminLoginHandler(@Valid @RequestBody AdminDTO dto) throws LoginException{
		String msg = aService.logIntoAccount(dto);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> adminLogoutHandler(@RequestParam String key) throws LoginException{
		String msg = aService.logOutFromAccount(key);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
}
