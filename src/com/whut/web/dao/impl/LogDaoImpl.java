package com.whut.web.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.whut.web.dao.LogDao;
import com.whut.web.entity.Log;
import com.whut.web.entity.Pager;

@Repository("logDao")
public class LogDaoImpl extends BaseDaoImpl<Log, Integer> implements LogDao {

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Log> getByPage(String hql, int page, int count,
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
			Pager<Log> pager = new Pager<Log>();
			pager.setList(query.list());
			
			totalRows = get(hql, params).size();
					
			pager.setPage(page);
			pager.setCount(count);
			pager.setTotalRows(totalRows);
			
			return pager;
		}
	}
	
}
