package com.cos.jwt.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

// 스프링 시큐리티에 UsernamePasswordAuthenticationFilter 필터가 있음.
// /login 요청해서 username, passoword 전송하면(post)
// UsernamePasswordAuthenticationFilter가 동작을 함.
@RequiredArgsConstructor
public class jwtAthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;
	
	// login요청을 하면 로그인 시도를 하기 위해 실행되는 함수
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("JwtAuthenticationFilter : 로그인 시도중");
		// 1. username, password를 받아서
		
		// 2. 정상인지 로그인 시도를 함. authenticationManager로 로그인 시도를 하면 
		// PrincipalDetailService가  호출 loadUserByUsername()함수가 실행됨.
		
		// 3. PrincipalDetails를 세션에 담고 (권한관리를 위해서)
		
		// 4. JWT토큰을 만들어서 응답하면 됨.
		
		return super.attemptAuthentication(request, response);
	}
}
