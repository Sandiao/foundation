package com.whut.web.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.whut.web.entity.Pager;

public interface BaseDao<T, ID extends Serializable> {
	
    /**
     * 功能：增加记录，存入数据库中
     *
     * @param entity
     * @return
     */
    public void save(Object entity);
    
    /**
     * 功能：批量增加记录
     *
     * @param entities
     * @return
     */
    public void batchSave(Object[] entities);
    
    /**
     * 功能：批量增加记录
     *
     * @param entities
     * @return
     */
    public void batchSave(List<T> entities);
    
    /**
     * 功能：查找单个记录
     *
     * @param id
     * @return
     */
	public T get(ID id);
	
    /**
     * 功能：根据id集合 查找记录集合
     *
     * @param ids
     * @return
     */
	public List<T> get(ID[] ids);
	
    /**
     * 功能：根据criterion约束集合查找记录集合
     *
     * @param criterions
     * @return
     */
	public List<T> get(List<Criterion> criterions);
	
    /**
     * 功能：根据entity中成员变量的值查找与这些值全部相等的记录集合
     * 这个方法是为了偷懒写的
     *
     * @param entity
     * @return
     */
	public List<T> get(Object entity);
	
    /**
     * 功能：根据关键字查找记录集合
     *
     * @param hql, params
     * @return
     */
	public List<T> get(String hql, Object... params);
	
    /**
     * 功能：分页查找记录集合
     *
     * @param currentPage, pageSize
     * @return
     */
	public Pager<T> getByPage(int currentPage, int pageSize);
	
    /**
     * 功能：查找记录集合
     *
     * @param id
     * @return
     */
	public List<T> getAll();
  
    /**
     * 功能：修改记录
     *
     * @param entity
     */
    public void update(Object entity);
    
    /**
     * 功能：修改记录
     *
     * @param hql, params
     */
    public void update(String hql, Object... params);
    
    /**
     * 功能：根据主键修改不为空的记录，注意例如bool类型，默认值不为null的变量(bool的默认值为false)。
     *
     * @param entity
     */
    public void updateNotNullField(Object entity);
    
    /**
     * 功能：修改记录
     *
     * @param entities
     */
    public void batchUpdate(Object[] entities);

    /**
     * 功能：删除记录
     *
     * @param entity
     */
    public void delete(Object entity);
    
    /**
     * 功能：删除记录
     *
     * @param id
     */
    public void delete(ID id);
    
    /**
     * 功能：删除记录
     *
     * @param entities
     */
    public void batchDelete(Object[] entities);
    
    /**
     * 功能：删除记录
     *
     * @param ids
     */
    public void batchDelete(ID[] ids);
    
    /**
     * 功能：获取表中记录总数
     *
     */
    public int getTotalCount();
    /**
	 * 功能：分页
	 * 
	 */
	public List<T> getListByPage(String hql,int currentPage, int pageSize,Object... params);
}
