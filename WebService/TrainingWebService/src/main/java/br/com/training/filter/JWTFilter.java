package br.com.training.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.training.util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureException;

public class JWTFilter implements Filter{

	@Override
	public void destroy() {	
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) servletRequest;
	    HttpServletResponse res = (HttpServletResponse) servletResponse;

	    if(!precisaDeAutenticacao(req) || req.getMethod().toString().equals("OPTIONS")){
	        filterChain.doFilter(servletRequest, servletResponse);
	        return;
	    }

	    String token = req.getHeader(JWTUtil.TOKEN_HEADER);

	    if(token == null || token.trim().isEmpty()){
	        res.setStatus(401);
	        return;
	    }

	    try {
	        Jws<Claims> parser = JWTUtil.decode(token);
	        System.out.println("User request: "+ parser.getBody().getSubject());
	        filterChain.doFilter(servletRequest, servletResponse);
	    } catch (SignatureException e) {
	        res.setStatus(401);
	    }
		
	}
	
	private boolean precisaDeAutenticacao(HttpServletRequest request){
		if(request.getRequestURI().contains("/api/login")){
			return false;
		}else if(request.getRequestURI().contains("/api/cadastroAluno")){
			return false;
		}else if(request.getRequestURI().contains("/api/cadastroProfessor")){
			return false;
		}
		return true;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
