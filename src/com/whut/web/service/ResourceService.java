package com.whut.web.service;

import java.util.List;

import com.whut.web.entity.Resource;

public interface ResourceService {

    /**
     * 功能：增加资源
     *
     * @param resource
     */
    public void save(Resource resource);
    
    /**
     * 功能：查找单个资源
     *
     * @param id
     * @return
     */
	public Resource get(int id);
	
    /**
     * 功能：查找资源集合
     *
     * @param id
     * @return
     */
	public List<Resource> getAll();
  
    /**
     * 功能：修改资源
     *
     * @param resource
     */
    public void update(Resource resource);
  
    /**
     * 功能：删除资源
     *
     * @param resource
     */
    public void delete(Resource resource);
    
}
