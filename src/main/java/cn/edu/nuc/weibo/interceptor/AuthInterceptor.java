package cn.edu.nuc.weibo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.weibo.entity.Account;

public class AuthInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.getRequestURI();
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		
		if( account != null )
			return true;
		
		String requestedWith = request.getHeader("x-requested-with");
		//Ajax
		if( requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest") ){
			response.setHeader("sessionstatus", "timeout");//在响应头设置session状态 
		} else {
			response.sendRedirect("/login");
		}
		return false;
	}


	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}


	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
