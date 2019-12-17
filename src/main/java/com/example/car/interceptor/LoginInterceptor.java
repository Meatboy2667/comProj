package com.example.car.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor 
extends HandlerInterceptorAdapter {

	//preHandle�� ���� �׼��� ����Ǳ� ��	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
					throws Exception {
		// ���� ��ü ����
		HttpSession session=request.getSession();
		//������ ������(�α��ε��� ���� ����
		if(session.getAttribute("userid") == null) {
			response.sendRedirect(request.getContextPath()
					+"/member/login.do?message=nologin");
			return false; //���� �׼����� ���� ����
		}else {
			return true; //���� �׼����� �̵�
		}
	}//preHandle()

	//���� �׼��� ����� ��

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}	

}
