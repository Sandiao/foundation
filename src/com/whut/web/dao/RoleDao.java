package com.whut.web.dao;

import java.util.List;

import com.whut.web.entity.Role;

public interface RoleDao extends BaseDao<Role, Integer> {
	
	public List<Role> queryList();
}
