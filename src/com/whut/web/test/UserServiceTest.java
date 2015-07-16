package com.whut.web.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.whut.web.dao.UserDao;

@ContextConfiguration(locations = { "classpath*:config/spring/applicationContext-orm.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
//记得要在XML文件中声明事务哦~~~我是采用注解的方式
@Transactional
public class UserServiceTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testSave(){
		System.out.println("------------");
	}
	
	@Test
	public void testQuery(){
		Assert.assertNotNull(userDao);  
		//System.out.println(userDao.get("liux"));
	}
	
}
