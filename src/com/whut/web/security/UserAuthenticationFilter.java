package com.whut.web.security;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.whut.web.entity.User;
import com.whut.web.service.UserService;

public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private static final String USERID = "userId";
	private static final String PASSWORD = "password";
	private static final String CHECKCODE = "checkCode";

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		String userId = obtainUsername(request);
		String password = obtainPassword(request);
		String checkCode = obtainCheckcode(request);
		
		// 验证验证码是否正确
		HttpSession session = request.getSession();
		
		String checkCodeSession = (String) session.getAttribute("rand");
		System.out.println("check code: " + checkCodeSession);
		if(!checkCodeSession.equals(checkCode)){
			BadCredentialsException exception = new BadCredentialsException("验证码错误");
			throw exception;
		}
			
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
/*		System.out.println("user Id--" + userId);
		System.out.println("password--" + password);*/
		
		// 验证用户账号与密码是否正确
		userId = userId.trim();
		User user = this.userService.get(userId);
		if (null == user || !passwordEncoder.matches(password, user.getPassword())) {
			BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配");
			throw exception;
		}
		
		Date currentDate = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		user.setLastlogintime(dateFormat.format(currentDate));
		System.out.println("login time: " + user.getLastlogintime());
		userService.update(user);

/*		try {
			Date deadTime = dateFormat.parse(user.getDeadTime());
			
			if (deadTime.getTime() > currentDate.getTime()) {
				BadCredentialsException exception = new BadCredentialsException("账号已过期");
				throw exception;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		//通过session把用户对象设置到session中
		request.getSession().setAttribute("userId", userId);
		request.getSession().setAttribute("username", user.getName());

		//实现验证
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userId, password);
		
		//允许设置用户详细属性
		setDetails(request, authRequest);
		
		//运行
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERID);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}
	
	protected String obtainCheckcode(HttpServletRequest request) {
		Object obj = request.getParameter(CHECKCODE);
		return null == obj ? "" : obj.toString();
	}
	
	@Override
	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
	}
}
