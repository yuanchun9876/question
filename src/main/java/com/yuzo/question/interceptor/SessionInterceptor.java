package com.yuzo.question.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor {
	
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws  Exception{
        
        if (request.getRequestURI().equals("/") ||request.getRequestURI().equals("/loginOut") || request.getRequestURI().equals("/main")||request.getRequestURI().equals("/error")){
            return true;
        }
         Object obj = request.getSession().getAttribute("user");
         if (obj == null){
        	 System.out.println("->" + request.getRequestURI());
             response.sendRedirect("/loginOut");
             return  false;
         }
         return true;
    }
}
