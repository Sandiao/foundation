package com.whut.web.dao;

import com.whut.web.entity.Log;
import com.whut.web.entity.Pager;

public interface LogDao extends BaseDao<Log, Integer> {
	
	public Pager<Log> getByPage(String hql, int currentPage, int pageSize, Object... params);

}
