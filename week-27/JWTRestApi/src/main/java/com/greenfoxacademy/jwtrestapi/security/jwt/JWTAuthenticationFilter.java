package com.greenfoxacademy.jwtrestapi.security.jwt;

import org.apache.coyote.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
          throws IOException, ServletException {
    Authentication authentication = JWTUtility.getAuthentication((HttpServletRequest) request);

    //System.out.println(SecurityContextHolder.getContext().getAuthentication());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    //System.out.println(SecurityContextHolder.getContext().getAuthentication());

    filterChain.doFilter(request, response);
  }

}
