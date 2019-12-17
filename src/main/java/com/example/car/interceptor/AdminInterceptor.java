package com.example.car.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor 
extends HandlerInterceptorAdapter {


	//��ó��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ���� ��ü ����
		HttpSession session=request.getSession();
		// ���Ǻ��� admin_userid�� ������
		if(session.getAttribute("admin_userid")==null) {
			response.sendRedirect(request.getContextPath()
					+"/admin/login.do?message=nologin");
			return false;
			//������ ������ ������ login�������� �̵�
		} else {
			return true;//���� ������ ������ ��� ����ó��
		}
	}//preHandle()

	//��ó��
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
