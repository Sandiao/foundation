package com.whut.web.service;

import java.util.List;

import com.whut.web.entity.Role;

public interface RoleService {

	/**
     * 功能：增加角色
     *
     * @param role
     */
    public void save(Role role);
    
    /**
     * 功能：查找单个角色
     *
     * @param id
     * @return
     */
	public Role get(int id);
	
    /**
     * 功能：查找单个角色
     *
     * @param hql, params
     * @return
     */
	public List<Role> get(String hql, Object... params);
	
    /**
     * 功能：查找角色集合
     *
     * @return
     */
	public List<Role> getAll();
	
    /**
     * 功能：查找角色集合，只包括id和name两个字段
     *
     * @return
     */
	public List<Role> queryList();
  
    /**
     * 功能：修改角色
     *
     * @param role
     */
    public void update(Role role);
  
    /**
     * 功能：删除角色
     *
     * @param role
     */
    public void delete(Role role);
    
    /**
     * 功能：删除角色
     *
     * @param id
     */
    public void delete(int id);
    
    /**
     * 功能：删除角色
     *
     * @param ids
     */
    public void batchDelete(Integer[] ids);
}
