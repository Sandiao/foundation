package com.whut.mybatis.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.whut.web.entity.Role;

@MapperScan("roleMapper")
public interface RoleMapper {
	
	public List<Role> queryList();
}
