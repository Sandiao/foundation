package com.whut.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.web.dao.ResourceDao;
import com.whut.web.entity.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl<Resource, Integer> implements ResourceDao {

}
