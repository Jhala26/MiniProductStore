package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.AdminDTO;
import com.masai.model.AdminDTO;
import com.masai.model.runningUserSession;
import com.masai.model.runningUserSession;
import com.masai.repository.RunningSessionDao;
import com.masai.repository.RunningSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private RunningSessionDao sDao;
	
	@Override
	public String logIntoAccount(AdminDTO dto) throws LoginException {
		
		Admin adm=new Admin();
		
		if(!adm.username.equalsIgnoreCase(dto.getUserName())) {
			throw new LoginException("Please Enter a valid username.");
		}
		
		Optional<runningUserSession> validUserSessionOpt =sDao.findById(adm.id); 
		
		if(validUserSessionOpt.isPresent()) {
			throw new LoginException("User already Logged in with this username.");
		}
		
		if(adm.password.equals(dto.getPassword())) {
			String key=RandomString.make(6);
			runningUserSession currentUserSession=new runningUserSession(adm.id,"Admin",key,LocalDateTime.now());
			sDao.save(currentUserSession);
			return currentUserSession.toString();
		}
		else {
			throw new LoginException("Please Enter a valid password");
		}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		runningUserSession validUserSession=sDao.findByUuid(key);
		
		if(validUserSession==null) {
			throw new LoginException("User not logged in with this username.");
		}
		sDao.delete(validUserSession);
		return "Logged out successfully.";
	}

}