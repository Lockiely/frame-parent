package com.lockiely.easy.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Service;

import com.lockiely.easy.dao.LogMapper;
import com.lockiely.easy.pojo.Log;
import com.lockiely.easy.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService{

	@Resource
	private LogMapper logMapper;
	
	public void log(Log log) {
		logMapper.insert(log);
	}

	public Long loginUserId() {
		return (long) 12978;
	}

	
}
