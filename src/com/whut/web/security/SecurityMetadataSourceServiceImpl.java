package com.whut.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.whut.web.entity.Resource;
import com.whut.web.service.ResourceService;

/**
 * 
 * 这里使用@Service会出错，原因不明，需要在xml里面配置bean，spring版本3.2.5，spring security版本3.1.0
 * 
 * @author
 * 
 */
public class SecurityMetadataSourceServiceImpl implements FilterInvocationSecurityMetadataSource {
	
	//这里使用@Autowired会出错，原因不明，需要在xml里面注入，spring版本3.2.5，spring security版本3.1.0
	private ResourceService resourceService;

	// 用于放置资源路径 对应该路径下的资源名称  -- 用户管理
	private static Map<RequestMatcher, Collection<ConfigAttribute>> resourceMap = null;
	
	public SecurityMetadataSourceServiceImpl(ResourceService resourceService) {
		
		this.resourceService = resourceService;
		loadResourceDefine();
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}

	@Override
	// 返回请求资源对应的权限(资源名称)
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		
		if (null == resourceMap) {
			this.loadResourceDefine();
		}
		
		System.out.println("--------------------------- 返回所请求资源所需要的权限 ");
		System.out.println("security configs: " + resourceMap.toString());
		
		String requestUrl = ((FilterInvocation) object).getRequestUrl().replaceAll(" ", "");
		System.out.println("request url: " + requestUrl);
		
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		String httpMethod = request.getMethod();
		System.out.println("request method: " + httpMethod);
		
/*		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
			
			RequestMatcher requestMatcher = entry.getKey();
			System.out.println("request matcher: " + requestMatcher.toString());
			if (requestMatcher.matches(request)) {
				
				return entry.getValue();
			}
		}*/
		
		return null;
		
/*		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();			
		ConfigAttribute configAttribute = new SecurityConfig("ROLE_NO_RESOURCE");
		configAttributes.add(configAttribute);
		
		return configAttributes;*/
		
/*		if (null == resourceMap.get(resource)) {
			
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();			
			ConfigAttribute configAttribute = new SecurityConfig("ROLE_NO_RESOURCE");
			configAttributes.add(configAttribute);
			
			return configAttributes;
		} else {
			
			return resourceMap.get(resource);
		}*/
	}
	
	private void loadResourceDefine() {
		
		if (null == resourceMap) {
			resourceMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();
			List<Resource> resources = this.resourceService.getAll();
			for (Resource resource : resources) {
				
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				
				// 资源名称必须加上ROLE
				ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + resource.getName());
				configAttributes.add(configAttribute);
				
				RequestMatcher requestMatcher = new AntPathRequestMatcher(resource.getUri(), resource.getMethod().toUpperCase());
				resourceMap.put(requestMatcher, configAttributes);
			}
		}
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// 这里必须是true
		return true;
	}

}
