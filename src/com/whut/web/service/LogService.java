package com.whut.web.service;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.whut.web.entity.Log;
import com.whut.web.entity.Pager;

public interface LogService {
    
	public Log get(int id);
	public void save(Log log);
	public void update(Log log);
	public void delete(Log log);
	public void delete(int id);
    /**
     * 功能：根据criterion约束集合查找记录集合
     *
     * @param criterions
     * @return
     */
	public List<Log> get(List<Criterion> criterions);
	
    /**
     * 功能：根据log中成员变量的值来查找与这些值全部相等的用户集合
     *
     * @param id
     * @return
     */
	public List<Log> get(Log log);
	
    /**
     * 功能：查找log集合
     *
     * @param id
     * @return
     */
	public List<Log> getAll();
	/**
     * 分页查询
     *
     * @param
     */
    public List<Log> getListByPage(String hql,int currentPage, int pageSize, Object... params);
    
    /*
	 * 查找当前页应该显示的记录
	 */
	public Pager<Log> getCurrentPageList(int currentPage, int pageSize, String hql, Object... params);
}
