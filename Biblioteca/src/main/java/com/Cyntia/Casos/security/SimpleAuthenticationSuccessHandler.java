package com.Cyntia.Casos.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
			Authentication authentication) throws IOException, ServletException {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			if (authority.getAuthority().equals("ROLE_PERITO")) {
				try {
					redirectStrategy.sendRedirect(arg0, arg1, "/area");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (authority.getAuthority().equals("ROLE_ADMINISTRADOR")) {
				try {
					redirectStrategy.sendRedirect(arg0, arg1, "/areaADM");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new IllegalStateException();
			}
		});
	}
}
