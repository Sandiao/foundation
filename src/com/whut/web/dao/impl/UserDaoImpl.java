package com.whut.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.whut.mybatis.mapper.UserMapper;
import com.whut.web.dao.UserDao;
import com.whut.web.entity.Pager;
import com.whut.web.entity.User;
import com.whut.web.entity.UserQueryBean;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	@Override
	public List<User> queryByPage(int currentPage, int pageSize) {
		
		int recordIndex = (currentPage - 1) * pageSize;
		
		return userMapper.queryByPage(recordIndex, pageSize);
	}
	
	@Override
	public int advancedQueryCount(UserQueryBean userQueryBean) {
		return userMapper.advancedQueryCount(userQueryBean);
	}
	
	@Override
	public int getTotalCount() {
		return userMapper.getTotalCount();
	}
	
	@Override
	public List<User> advancedQuery(UserQueryBean userQueryBean) {
		return userMapper.advancedQuery(userQueryBean);
	}

	@Override
	public List<User> advancedQueryByPage(UserQueryBean userQueryBean,
			int currentPage, int pageSize) {
		
		int recordIndex = (currentPage - 1) * pageSize;
		
		return userMapper.advancedQueryByPage(userQueryBean, recordIndex, pageSize);
	}
	
	@Override
	public List<User> advancedQueryByPageWithRoles(UserQueryBean userQueryBean,
			int page, int count) {
		
		int recordIndex = (page - 1) * count;
		
		return userMapper.advancedQueryByPageWithRoles(userQueryBean, recordIndex, count);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<User> getByPage(String hql, int page, int count,
			Object... params) {
		if (null == params || 0 == params.length) {
			return getByPage(page, count);
		} else {
			Query query = this.getHibernateSession().createQuery(hql);
			for (int index = 0; index < params.length; ++index) {
				query.setParameter(index, params[index]);
			}
			int firstRecord = (page - 1) * count;
			int totalRows = 0;
			query.setFirstResult(firstRecord);
			query.setMaxResults(count);
			Pager<User> pager = new Pager<User>();
			pager.setList(query.list());
			
			totalRows = get(hql, params).size();
					
			pager.setPage(page);
			pager.setCount(count);
			pager.setTotalRows(totalRows);
			
			return pager;
		}
	}

}
