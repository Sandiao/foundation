package com.whut.web.dao.impl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AnnotationUtils;

import com.whut.web.dao.BaseDao;
import com.whut.web.entity.Pager;

public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
	
	private Class<T> entityClass; 

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory hibernateSessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
        Type genericType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genericType).getActualTypeArguments();
        entityClass = (Class) params[0];
	}
	
	protected Session getHibernateSession() {
		return this.hibernateSessionFactory.getCurrentSession();
	}
	
	protected void basicSave(Object entity) {
		
		this.getHibernateSession().save(entity);
		
	}
	
	protected void basicUpdate(Object entity) {
		
		this.getHibernateSession().update(entity);
		
	}
	
	protected void basicDelete(Object entity) {
		
		this.getHibernateSession().delete(entity);
		
	}
	
	@Override
	public void save(Object entity) {
		
		this.basicSave(entity);
		this.getHibernateSession().flush();
		
	}
	
	@Override
	public void batchSave(Object[] entities) {
		
		if (null == entities || 0 == entities.length) return;
		
		for (int index = 0; index < entities.length; ++index) {
			this.basicSave(entities[index]);
		}
		this.getHibernateSession().flush();
	}
	
	@Override
	public void batchSave(List<T> entities) {
		
		if (null == entities || entities.isEmpty()) return;
		
		for (T entity : entities){
			this.basicSave(entity);
		}
		this.getHibernateSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(ID id) {
		return (T) this.getHibernateSession().get(this.entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(ID[] ids) {
		if (null == ids || 0 == ids.length) return Collections.EMPTY_LIST;
		String getByIds = "from " + entityClass.getName() + " where id in(:ids)";
		Query query = this.getHibernateSession().createQuery(getByIds)
				.setParameterList("ids", ids);
		return query.list();
	}
	
    /**
     * 功能：根据约criterion约束集合创造查询对象
     *
     * @param criterions
     * @return
     */
	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = this.getHibernateSession().createCriteria(entityClass);
		
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		
		return criteria;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(List<Criterion> criterions) {
		return this.createCriteria().list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(Object entity) {
		
		Criteria criteria = this.getHibernateSession().createCriteria(entityClass);
		
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			
			Class<?> clazz = field.getType();
			if (String.class != clazz && !clazz.isPrimitive()) continue;
			
			try {
				String propertyName = field.getName();
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, entityClass);
				Method propertyGetter = propertyDescriptor.getReadMethod();
				Object getValue = propertyGetter.invoke(entity);

				if (null == getValue) continue;
				criteria.add(Restrictions.eq(propertyName, getValue));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(String hql, Object... params) {
		
		if (null == params || 0 == params.length) return Collections.EMPTY_LIST;
		
		Query query = this.getHibernateSession().createQuery(hql);
		for (int index = 0; index < params.length; ++index) {
			query.setParameter(index, params[index]);
		}
		return query.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pager<T> getByPage(int page, int count) {
		
		String getAll = "from " + entityClass.getName();
		Query query = this.getHibernateSession().createQuery(getAll);
		
		int firstRecord = (page - 1) * count;
		int totalRows = this.getTotalCount();
		query.setFirstResult(firstRecord);
		query.setMaxResults(count);
		Pager<T> pager = new Pager<T>();
		pager.setList(query.list());
		
		pager.setPage(page);
		pager.setCount(count);
		pager.setTotalRows(totalRows);
		
		return pager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getListByPage(String hql, int currentPage, int pageSize,
			Object... params) {

		if (null == params || 0 == params.length) {
			Query query = this.getHibernateSession().createQuery(hql);
			int firstRecord = (currentPage - 1) * pageSize;
			query.setFirstResult(firstRecord);
			query.setMaxResults(pageSize);
			List<T> list = query.list();
			//Collections.reverse(list);
			return list;
		} else {
			Query query = this.getHibernateSession().createQuery(hql);
			for (int index = 0; index < params.length; ++index) {
				query.setParameter(index, params[index]);
			}
			int firstRecord = (currentPage - 1) * pageSize;
			query.setFirstResult(firstRecord);
			query.setMaxResults(pageSize);
			List<T> list = query.list();
			//Collections.reverse(list);
			return list;
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		String getAll = "from " + entityClass.getName();
		Query query = this.getHibernateSession().createQuery(getAll);
		return query.list();
	}
	
	@Override
	public void update(Object entity) {
		
		this.basicUpdate(entity);
		this.getHibernateSession().flush();
	}
	
	@Override
	public void update(String hql, Object... params) {
		
		if (null == params || 0 == params.length) return;
		
		Query query = this.getHibernateSession().createQuery(hql);
		for (int index = 0; index < params.length; ++index) {
			query.setParameter(index, params[index]);
		}
		query.executeUpdate();
		
	}
	
	@Override
	public void updateNotNullField(Object entity) {
		
		if (null == entity) return;
		
		String hql = "update " + entityClass.getSimpleName() + " set ";
		String where = " where ";
		List<Object> params = new ArrayList<Object>();
		Object idParam = null;
		boolean flag = false;
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			
			Class<?> clazz = field.getType();
			if (!(String.class == clazz || Integer.class == clazz || Date.class == clazz) && !clazz.isPrimitive()) continue;
			// System.out.println(clazz.getName());
			try {
				String columnName = null;
				String propertyName = field.getName();
				if (propertyName.equals("serialVersionUID")) continue;
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, entityClass);
				// System.out.println("propertyDescriptor:" + propertyDescriptor);
				Method propertyGetter = propertyDescriptor.getReadMethod();
				if (null == propertyGetter) continue;
				
				Object getValue = propertyGetter.invoke(entity);
				if (null == getValue) continue;
				
				Column column = AnnotationUtils.findAnnotation(propertyDescriptor.getReadMethod(), Column.class);
				if (null == column) {
					columnName = propertyName;
				} else {
					String columnAnnotationName = column.name();
					if (null == columnAnnotationName || columnAnnotationName.equals("")) {
						columnName = propertyName;
					} else {
						columnName = columnAnnotationName;
					}
				}
				
				Id id = AnnotationUtils.findAnnotation(propertyDescriptor.getReadMethod(), Id.class);
				if (null == id) {
					if (flag) {
						hql += ", ";
					} else {
						flag = true;
					}
					hql += columnName + " = ?";
					params.add(getValue);
				} else {
					where += columnName + " = ?";
					idParam = getValue;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		hql += where;
		System.out.println(hql);
		params.add(idParam);
		this.update(hql, params.toArray());
	}
	
	@Override
	public void batchUpdate(Object[] entities) {
		
		if (null == entities || 0 == entities.length) return;
		
		for (int index = 0; index < entities.length; ++index) {
			this.basicUpdate(entities[index]);
		}
		this.getHibernateSession().flush();
	}
	
	@Override
	public void delete(Object entity) {
		
		this.basicDelete(entity);
		this.getHibernateSession().flush();
	}
	
	@Override
	public void delete(ID id) {
		
		Object entity = this.get(id);
		this.basicDelete(entity);
		this.getHibernateSession().flush();
	}
	
	@Override
	public void batchDelete(Object[] entities) {
		
		if (null == entities || 0 == entities.length) return;
		
		for (int index = 0; index < entities.length; ++index) {
			this.basicDelete(entities[index]);
		}
		this.getHibernateSession().flush();
	}
	
	@Override
	public void batchDelete(ID[] ids) {
		
		if (null == ids || 0 == ids.length) return;
		List<T> entities = this.get(ids);
		
		for (T entity : entities) {
			this.basicDelete(entity);
		}
		this.getHibernateSession().flush();
	}
	
	@Override
	public int getTotalCount() {
		String getCount = "select count(*) from " + entityClass.getName();
		Query query = this.getHibernateSession().createQuery(getCount);
		return ((Number)query.uniqueResult()).intValue();
		
	}

}
