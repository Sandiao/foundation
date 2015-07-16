package com.whut.web.log;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.whut.web.dao.LogDao;
import com.whut.web.entity.Log;
import com.whut.web.util.Common;

@Component
@Aspect
public class LogAspect {
	// @Pointcut("execution(* com.whut.web.service.impl.*.*(..))")
	@Autowired
	private LogDao logDao;
	
	@After(value = "execution(* com.whut.web.service.impl.*.*(..))")
	public void logInfo(JoinPoint jp) {
		String className = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		int flag = 0;
		// 操作用户
		String user = null;
		// 操作时间
		String operTime = null;
		// 登录IP
		String ip = null;
		try {
			// 执行方法所消耗的时间

			ip = InetAddress.getLocalHost().getHostAddress();
			// 登录名
			UserDetails principal = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			user = principal.getUsername();
			System.out.println("=====用户:" + user);
		} catch (Throwable e) {
			// e.printStackTrace();
		}

		System.out.println("======================");
		System.out.println("=====位于:" + className);
		System.out.println("=====调用:" + methodName + "方法--开始！");

		Object[] args = jp.getArgs();
		if (args.length <= 0) {
			flag = 1;
			System.out.println("====" + methodName + "方法没有参数");
		}/* else {
			for (int i = 0; i < args.length; i++) {
				System.out.println("====参数  " + (i + 1) + "：" + args[i]);
				if((args[i].toString().indexOf("Log") > -1)&&(args[i]!=null)){
					System.out.println(args[i].toString().indexOf("Log"));
					flag = 1;
				}
			}
		}*/
		System.out.println("======================");

		String name = null;
		// 操作范围
		if (className.indexOf("Resource") > -1) {
			name = "资源";
		} else if (className.indexOf("Role") > -1) {
			name = "角色";
		} else if (className.indexOf("User") > -1) {
			name = "用户";
		} else if (className.indexOf("Survey") > -1) {
			name = "问卷";
		} else if (className.indexOf("Question") > -1) {
			name = "题目";
		} else if (className.indexOf("Log") > -1) {
			flag = 1;
		} else if (className.indexOf("Option") > -1) {
			flag = 1;
		}
		// 操作类型
		String opertype = "";
		if (methodName.indexOf("saveUserRole") > -1) {
			opertype = "update用户的角色";
		} else if (methodName.indexOf("saveRoleRescours") > -1) {
			opertype = "update角色的权限";
		} else if (methodName.indexOf("add") > -1
				|| methodName.indexOf("save") > -1) {
			opertype = "新增"+name;
		} else if (methodName.indexOf("update") > -1
				|| methodName.indexOf("modify") > -1) {
			opertype = "更新"+name;
		} else if (methodName.indexOf("delete") > -1) {
			opertype = "删除"+name;
		} else if (methodName.indexOf("get") > -1) {
			opertype = "查看"+name;
		}

		if(!Common.isEmpty(opertype)&&(flag==0)){
			Log log = new Log();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			operTime = df.format(new Date());
			/*if(user==null){
				for (int i = 0; i < args.length; i++){
					log.setName(args[i].toString());
				}
				log.setModule("登录模块");
				log.setAction("登录系统");
			} else{*/
				log.setName(user);
				log.setModule(name+"管理模块");
				log.setAction(opertype);
			//}
			
			log.setOperTime(operTime);
			log.setUserIP(ip);
			logDao.save(log);
		}
	}

}
