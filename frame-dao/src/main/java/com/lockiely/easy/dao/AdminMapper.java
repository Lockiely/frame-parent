package com.lockiely.easy.dao;

import com.lockiely.easy.pojo.Admin;

public interface AdminMapper {

	public Admin findAdminByNickname(String nickName);
}
