package com.whut.web.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		
		System.out.println("--------------------------- user access decision");
		if (configAttributes.toString().equals("[ROLE_NO_RESOURCE]")) {
			
			System.out.println("no permission matched");
			throw new AccessDeniedException("没有权限访问！");
		}

		// 所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			// 访问所请求资源所需要的权限
			String permissionRequired = configAttribute.getAttribute();
			System.out.println("permission required:" + permissionRequired);
			
			// 用户所拥有的权限authentication
			System.out.println("permission owned:" + authentication.getAuthorities().toString());
			for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
				if (permissionRequired.equals(grantedAuthority.getAuthority())) {
					return;
				}
			}
		}
		// 没有权限让我们去捕捉
		System.out.println("no permission matched");
		System.out.println();
		throw new AccessDeniedException("没有权限访问！");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		// 这里必须是true
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// 这里必须是true
		return true;
	}


}
