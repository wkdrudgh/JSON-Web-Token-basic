package com.cos.jwt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter3 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// 토큰 : 코스 이걸 만들어야 함. id, pw가 로그인이 정상적으로 성공하면 토큰을 만들어주고 그걸 응답한다.
		// header에 Authorization에 value값이 내가 만든 토큰인지만 검증하면됨. ( RSA, HS256  )
		if(req.getMethod().equals("POST")) {
			String headerAuth = req.getHeader("Authorization");	
			System.out.println(headerAuth);
			System.out.println("필터3");
			
			if(headerAuth.equals("token")) {
				chain.doFilter(req, res);
			}else {
				PrintWriter out = res.getWriter();
				out.print("인증안됨");
			}
		}
	}

}
