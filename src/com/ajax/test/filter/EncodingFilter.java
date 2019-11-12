package com.ajax.test.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "EncodingFilter",urlPatterns = {"*"})
public class EncodingFilter implements Filter {

   
    public EncodingFilter() {
       System.out.println("난 필터 자동 실행됨");
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		/*
		 * HttpServletRequest req = (HttpServletRequest)request;
		 * System.out.println(req.getRequestURI());
		 */
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
