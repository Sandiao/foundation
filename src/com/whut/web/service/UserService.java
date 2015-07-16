package com.whut.web.service;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.whut.web.entity.Pager;
import com.whut.web.entity.User;
import com.whut.web.entity.UserQueryBean;

public interface UserService {
	
    /**
     * 功能：增加用户
     *
     * @param user
     */
    public void save(User user);
    
    /**
     * 功能：批量增加用户
     *
     * @param users
     */
    public void batchSave(List<User> users);
    
    /**
     * 功能：查找单个用户
     *
     * @param id
     * @return
     */
	public User get(String id);
	
    /**
     * 功能：根据criterion约束集合查找记录集合
     *
     * @param criterions
     * @return
     */
	public List<User> get(List<Criterion> criterions);
	
    /**
     * 功能：根据user中成员变量的值来查找与这些值全部相等的用户集合
     *
     * @param id
     * @return
     */
	public List<User> get(User user);
	
    /**
     * 功能：查找用户集合
     *
     * @param id
     * @return
     */
	public List<User> getAll();
	
	/**
     * 功能：根据关键字查找记录集合
     *
     * @param hql, params
     * @return
     */
	public List<User> get(String hql, Object... params);
	
    /**
     * 功能：查找用户集合
     *
     * @param userQueryBean
     * @return
     */
	public List<User> advancedQuery(UserQueryBean userQueryBean);
	
    /**
     * 功能：分页查找用户集合
     *
     * @param userQueryBean
     * @return
     */
	public List<User> advancedQueryByPage(UserQueryBean userQueryBean, int currentPage, int pageSize);
	
    /**
     * 功能：分页查找用户集合
     *
     * @param userQueryBean
     * @return
     */
	public List<User> advancedQueryByPageWithRoles(UserQueryBean userQueryBean, int currentPage, int pageSize);

    /**
     * 功能：查找用户集合
     *
     * @param currentPage, pageSize
     * @return
     */
	public List<User> queryByPage(int currentPage, int pageSize);
	
    /**
     * 功能：修改用户信息
     *
     * @param user
     */
    public void update(User user);
    
    /**
     * 功能：修改用户信息,只修改非空的值
     *
     * @param user
     */
    public void updateNotNullField(User user);
  
    /**
     * 功能：删除用户
     *
     * @param user
     */
    public void delete(User user);
    
    /**
     * 功能：删除用户
     *
     * @param id
     */
    public void delete(String id);
    
    /**
     * 功能：批量删除用户
     *
     * @param ids
     */
    public void batchDelete(String[] ids);
    
    /**
     * 功能：查找记录数
     *
     */
    public int getTotalCount();
    
    /**
     * 功能：查找记录数
     *
     */
    public int advancedQueryCount(UserQueryBean userQueryBean);
    
    /*
	 * 查找当前页应该显示的记录
	 */
	public Pager<User> getCurrentPageList(int currentPage, int pageSize, String hql, Object... params);
    
}
