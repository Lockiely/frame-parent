package com.lockiely.easy.service.impl;


import org.springframework.stereotype.Service;

import com.lockiely.easy.dao.AdminMapper;
import com.lockiely.easy.pojo.Admin;
import com.lockiely.easy.service.AdminService;
import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Resource
	private AdminMapper adminMapper;

	public Admin findAdminByNickname(String nickName) {
		return adminMapper.findAdminByNickname(nickName);
	}

}
