package com.whut.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.web.dao.RoleDao;
import com.whut.web.entity.Role;
import com.whut.web.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	@Qualifier("roleDao")
	private RoleDao roleDao;

	@Override
	public void save(Role role) {
		roleDao.save(role);
		
	}

	@Override
	public Role get(int id) {
		return roleDao.get(id);
	}
	
	@Override
	public List<Role> get(String hql, Object... params) {
		return roleDao.get(hql, params);
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
		
	}

	@Override
	public void delete(Role role) {
		roleDao.delete(role);
		
	}

	@Override
	public void delete(int id) {
		roleDao.delete(id);
		
	}

	@Override
	public void batchDelete(Integer[] ids) {
		roleDao.batchDelete(ids);
		
	}

	@Override
	public List<Role> queryList() {
		return roleDao.queryList();
	}

}
