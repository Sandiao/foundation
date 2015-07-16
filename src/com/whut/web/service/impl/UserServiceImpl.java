package com.whut.web.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.web.dao.UserDao;
import com.whut.web.entity.Pager;
import com.whut.web.entity.User;
import com.whut.web.entity.UserQueryBean;
import com.whut.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public User get(String id) {
		return userDao.get(id);
	}
	
	@Override
	public List<User> get(List<Criterion> criterions) {
		return userDao.get(criterions);
	}
	
	@Override
	public List<User> get(User user) {
		return userDao.get(user);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public List<User> advancedQuery(UserQueryBean userQueryBean) {
		return userDao.advancedQuery(userQueryBean);
	}
	
	@Override
	public List<User> queryByPage(int currentPage, int pageSize) {
		return userDao.queryByPage(currentPage, pageSize);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}
	
	@Override
	public void updateNotNullField(User user) {
		userDao.updateNotNullField(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
	
	@Override
	public void delete(String id) {
		userDao.delete(id);
	}
	
	@Override
	public void batchDelete(String[] ids) {
		userDao.batchDelete(ids);
	}

	@Override
	public int getTotalCount() {
		return userDao.getTotalCount();
	}

	@Override
	public List<User> advancedQueryByPage(UserQueryBean userQueryBean,
			int currentPage, int pageSize) {
		return userDao.advancedQueryByPage(userQueryBean, currentPage, pageSize);
	}
	
	@Override
	public List<User> advancedQueryByPageWithRoles(UserQueryBean userQueryBean,
			int currentPage, int pageSize) {
		return userDao.advancedQueryByPageWithRoles(userQueryBean, currentPage, pageSize);
	}

	@Override
	public int advancedQueryCount(UserQueryBean userQueryBean) {
		return userDao.advancedQueryCount(userQueryBean);
	}
	
	@Override
	public List<User> get(String hql, Object... params){
		return userDao.get(hql,params);
	}

	@Override
	public void batchSave(List<User> users) {
		userDao.batchSave(users);
		
	}

	@Override
	public Pager<User> getCurrentPageList(int currentPage, int pageSize,
			String hql, Object... params) {
		Pager<User> pager = null;
		if (hql == null && params == null) {
			pager = userDao.getByPage(currentPage, pageSize);
		} else {
			pager = userDao.getByPage(hql, currentPage, pageSize, params);
		}
		return pager;
	}
}
