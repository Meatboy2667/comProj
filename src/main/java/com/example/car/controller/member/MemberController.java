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

@Controller //컨트롤러 빈으로 등록
@RequestMapping("member/*") //공통적인 url 매핑
public class MemberController {
	//로깅을 위한 변수
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberService memberService;
	
	@RequestMapping("address.do")
	public String address() {
		return "member/join";
	}
	
	@RequestMapping("login.do") //세부적인 url 매핑
	public String login() {
		return "member/login"; //login.jsp로 이동
	}//login()
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(
			MemberDTO dto, HttpSession session) {
		//로그인 성공 true, 실패 false
		boolean result=memberService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) { //로그인 성공
			mav.setViewName("home"); //뷰의 이름
		}else { //로그인 실패
			mav.setViewName("member/login");
			//뷰에 전달할 값
			mav.addObject("message", "error");
		}
		return mav;
	}//login_check()
	
	@RequestMapping("logout.do")
	public ModelAndView logout(
			HttpSession session, ModelAndView mav) {
		//세션 초기화
		memberService.logout(session);
		// login.jsp로 이동
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}//logout()

}
