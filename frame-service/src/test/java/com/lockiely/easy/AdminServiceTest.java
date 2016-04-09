package com.lockiely.easy;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lockiely.easy.pojo.Admin;
import com.lockiely.easy.service.AdminService;

public class AdminServiceTest extends BaseServiceTest{

	@Resource
	private AdminService adminService;
	
	@Test
	public void test() {
		Admin admin = adminService.findAdminByNickname("lijin");
		System.out.println(admin.getNickname()+"的密码是"+admin.getPasswd());
	}
}
