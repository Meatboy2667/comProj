package com.example.car.controller.admin;

import javax.inject.Inject;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.model.member.dto.MemberDTO;
import com.example.car.service.admin.AdminService;

@Controller
@RequestMapping("admin/*") //�������� url mapping
public class AdminController {
	
	@Inject //�������� ����
	AdminService adminService;
	
	@RequestMapping("login.do") //�������� url mapping
	public String login() {
		return "admin/login"; //views/admin/login.jsp�� �̵�
	}//login()
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(MemberDTO dto
			, HttpSession session, ModelAndView mav) {
		String name=adminService.loginCheck(dto);//�α��� üũ
		if(name != null) {//�α��� ����=>���Ǻ��� ����
			//�����ڿ� ���Ǻ���
			session.setAttribute("admin_userid", dto.getUserid());
			session.setAttribute("admin_name", name);
			//�Ϲ� ����ڿ� ���Ǻ���
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
			mav.setViewName("admin/admin");//home.jsp�� �̵�
		}else { //�α��� ����
			mav.setViewName("admin/login"); //login.jsp�� �̵�
			mav.addObject("message","error");
		}
		return mav;
	}//login_check()
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); //���� �ʱ�ȭ
		//������ �α��� �������� �̵�
		return "redirect:/admin/login.do";
	}

}
