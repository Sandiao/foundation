package com.whut.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.whut.mybatis.mapper.RoleMapper;
import com.whut.web.dao.RoleDao;
import com.whut.web.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role, Integer> implements RoleDao {
	
	@Autowired
	@Qualifier("roleMapper")
	private RoleMapper roleMapper;

	@Override
	public List<Role> queryList() {
		return roleMapper.queryList();
	}

}
