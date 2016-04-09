package com.lockiely.easy.service;

import org.springframework.transaction.annotation.Transactional;

import com.lockiely.easy.pojo.Log;

public interface LogService {

	@Transactional
	public void log(Log log);
	
	public Long loginUserId();
}
