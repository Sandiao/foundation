package com.whut.web.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		handle(request, response, authentication);  
        clearAuthenticationAttributes(request);  
	}
	
    protected void handle(HttpServletRequest request, 
    		HttpServletResponse response, Authentication authentication) throws IOException {  
        String targetUrl = determineTargetUrl(authentication);
   
        redirectStrategy.sendRedirect(request, response, targetUrl);  
    }
    
    protected String determineTargetUrl(Authentication authentication) {
        boolean isAdmin = false;  
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();  
        for (GrantedAuthority grantedAuthority : authorities) {
        	String roleName = grantedAuthority.getAuthority();
            if (roleName.equals("ROLE_超级管理员")) {  
            	isAdmin = true;  
                break;  
            }
        }
   
        if (isAdmin) {  
            return "/page/public/admin.jsp";
        } else {  
            return "/page/public/general.jsp";
        }
    }
    
    protected void clearAuthenticationAttributes(HttpServletRequest request) {  
        HttpSession session = request.getSession(false);  
        if (null == session) {  
            return;  
        }  
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);  
    }
   
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {  
        this.redirectStrategy = redirectStrategy;  
    }
    
    protected RedirectStrategy getRedirectStrategy() {  
        return redirectStrategy;  
    }

}
