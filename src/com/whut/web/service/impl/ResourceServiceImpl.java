package com.whut.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.web.dao.ResourceDao;
import com.whut.web.entity.Resource;
import com.whut.web.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	@Qualifier("resourceDao")
	private ResourceDao resourceDao;

	@Override
	public void save(Resource resource) {
		resourceDao.save(resource);
		
	}

	@Override
	public Resource get(int id) {
		return resourceDao.get(id);
	}

	@Override
	public List<Resource> getAll() {
		return resourceDao.getAll();
		 
	}

	@Override
	public void update(Resource resource) {
		resourceDao.update(resource);
		
	}

	@Override
	public void delete(Resource resource) {
		resourceDao.delete(resource);
		
	}

}
