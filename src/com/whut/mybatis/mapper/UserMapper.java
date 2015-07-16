package com.whut.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.whut.web.entity.User;
import com.whut.web.entity.UserQueryBean;

@MapperScan("userMapper")
public interface UserMapper {
	
	public List<User> queryByPage(@Param("recordIndex") int recordIndex, @Param("pageSize")int pageSize);

	public int getTotalCount();
	
	public int advancedQueryCount(UserQueryBean userQueryBean);
	
	public List<User> advancedQuery(UserQueryBean userQueryBean);
	
	public List<User> advancedQueryByPage(@Param("userQueryBean")UserQueryBean userQueryBean,
		   @Param("recordIndex") int recordIndex, @Param("pageSize")int pageSize);
	
	public List<User> advancedQueryByPageWithRoles(@Param("userQueryBean")UserQueryBean userQueryBean,
			   @Param("recordIndex") int recordIndex, @Param("pageSize")int pageSize);
}