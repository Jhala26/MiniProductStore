package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.runningUserSession;

@Repository
public interface RunningSessionDao extends JpaRepository<runningUserSession, Integer>{

	public runningUserSession findByUuid(String uuid);
	
}
