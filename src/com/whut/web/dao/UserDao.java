package com.whut.web.dao;

import java.util.List;

import com.whut.web.entity.Pager;
import com.whut.web.entity.User;
import com.whut.web.entity.UserQueryBean;

public interface UserDao extends BaseDao<User, String> {
	
	public List<User> queryByPage(int currentPage, int pageSize);
	
	public int getTotalCount();
	
	public int advancedQueryCount(UserQueryBean userQueryBean);
	
	public List<User> advancedQuery(UserQueryBean userQueryBean);
	
	public List<User> advancedQueryByPage(UserQueryBean userQueryBean, int currentPage, int pageSize);
	
	public List<User> advancedQueryByPageWithRoles(UserQueryBean userQueryBean, int currentPage, int pageSize);
	
	public Pager<User> getByPage(String hql, int currentPage, int pageSize, Object... params);
	
}
