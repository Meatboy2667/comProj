package com.example.car.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.model.member.dto.MemberDTO;
import com.example.car.service.member.MemberService;

@Controller //��Ʈ�ѷ� ������ ���
@RequestMapping("member/*") //�������� url ����
public class MemberController {
	//�α��� ���� ����
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberService memberService;
	
	@RequestMapping("address.do")
	public String address() {
		return "member/join";
	}
	
	@RequestMapping("login.do") //�������� url ����
	public String login() {
		return "member/login"; //login.jsp�� �̵�
	}//login()
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(
			MemberDTO dto, HttpSession session) {
		//�α��� ���� true, ���� false
		boolean result=memberService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) { //�α��� ����
			mav.setViewName("home"); //���� �̸�
		}else { //�α��� ����
			mav.setViewName("member/login");
			//�信 ������ ��
			mav.addObject("message", "error");
		}
		return mav;
	}//login_check()
	
	@RequestMapping("logout.do")
	public ModelAndView logout(
			HttpSession session, ModelAndView mav) {
		//���� �ʱ�ȭ
		memberService.logout(session);
		// login.jsp�� �̵�
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}//logout()

}
