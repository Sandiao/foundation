package com.whut.web.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.web.dao.LogDao;
import com.whut.web.entity.Log;
import com.whut.web.entity.Pager;
import com.whut.web.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {

	@Autowired
	@Qualifier("logDao")
	private LogDao logDao;

	@Override
	public Log get(int id) {
		// TODO Auto-generated method stub
		return logDao.get(id);
	}

	@Override
	public void save(Log log) {
		// TODO Auto-generated method stub
		logDao.save(log);
	}

	@Override
	public void update(Log log) {
		// TODO Auto-generated method stub
		logDao.update(log);
	}

	@Override
	public void delete(Log log) {
		// TODO Auto-generated method stub
		logDao.delete(log);
	}

	@Override
	public List<Log> get(List<Criterion> criterions) {
		// TODO Auto-generated method stub
		return logDao.get(criterions);
	}

	@Override
	public List<Log> get(Log log) {
		// TODO Auto-generated method stub
		return logDao.get(log);
	}

	@Override
	public List<Log> getAll() {
		// TODO Auto-generated method stub
		return logDao.getAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		logDao.delete(id);
	}
	
	@Override
	public List<Log> getListByPage(String hql, int currentPage, int pageSize,
			Object... params) {
		// TODO Auto-generated method stub
		return logDao.getListByPage(hql, currentPage, pageSize, params);
	}

	@Override
	public Pager<Log> getCurrentPageList(int currentPage, int pageSize,
			String hql, Object... params) {
		Pager<Log> pager = null;
		if (hql == null && params == null) {
			pager = logDao.getByPage(currentPage, pageSize);
		} else {
			pager = logDao.getByPage(hql, currentPage, pageSize, params);
		}
		return pager;
	}
}
