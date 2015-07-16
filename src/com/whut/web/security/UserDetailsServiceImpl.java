package com.whut.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.whut.web.entity.Resource;
import com.whut.web.entity.Role;
import com.whut.web.entity.User;
import com.whut.web.entity.UserSecurityInfo;
import com.whut.web.service.UserService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		User user = userService.get(userId);
		
		Collection<GrantedAuthority> authorities = getAuthorities(user);
		
		UserDetails userDetails = new UserSecurityInfo(user.getId(), user.getName(), user.getPassword(),
								   		user.isEnabled(), true, true, true, authorities);
		return userDetails;
	}
	
	// 取得用户的权限
	private Set<GrantedAuthority> getAuthorities(User user) {
		List<Resource> resourceList = new ArrayList<Resource>();
		
		Set<Role> roles = user.getRoles();		
		for (Role role : roles) {
			Set<Resource> resourceSet = role.getResources();
			for (Resource resource : resourceSet) {
				resourceList.add(resource);
			}
		}
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Resource resource : resourceList) {
			// 用户取到的资源名称 必须以ROLE_开头
			authorities.add(new SimpleGrantedAuthority("ROLE_" + resource.getName()));
		}
		return authorities;
		
	}

}
