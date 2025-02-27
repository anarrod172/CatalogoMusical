package com._odam.apiRestCatalogoMusica.seguridad;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint{
	
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException, java.io.IOException {
        System.out.println("En el AuthEntryPoint");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
