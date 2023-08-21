package com.test.app.config.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler{

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.out.println("CustomLogoutHandler's logout!");
		HttpSession session = request.getSession(false); //false로 해야 새로운 session 만들지 않는다!
		if(session!=null) {
			session.invalidate();
		}
		
	}

}
