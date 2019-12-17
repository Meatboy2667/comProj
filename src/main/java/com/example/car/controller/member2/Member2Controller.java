package com.example.car.controller.member2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.car.model.member2.dto.Member2DTO;
import com.example.car.service.member2.Member2Service;

@Controller //���������� �����ϴ� ��Ʈ�ѷ� ������ ���
public class Member2Controller {

	//MemberService �ν��Ͻ��� ���Խ�Ŵ
	@Inject
	Member2Service member2Service;
	
	@RequestMapping("member2/list.do") //url mapping
	public String memberList(Model model) {
		List<Member2DTO> list=member2Service.memberList();
		model.addAttribute("list", list);
		// WEB-INF/views/member/member_list.jsp ������
		return "member2/member_list";
	}//memberList()
	
	@RequestMapping("member2/write.do") //url mapping
	public String write() {
		//WEB-INF/views/member/write.jsp�� ������
		return "member2/write";
	}//write()
	
	@RequestMapping("member2/insert.do")
	public String insert(@ModelAttribute Member2DTO dto) {
		member2Service.insertMember(dto);
		return "redirect:/member/login.do";
	}//insert()
	
	//@RequestParam : request.getParameter("������") ��ü
	@RequestMapping("member2/view.do")
	public String view(@RequestParam String userid, Model model) {
		//�𵨿� �ڷ� ����
		model.addAttribute("dto", member2Service.viewMember(userid));
		// view.jsp�� ������
		return "member2/view";
	}//view()
	
	@RequestMapping("member2/update.do")
	public String update(Member2DTO dto, Model model) {
		//��й�ȣ üũ
		boolean result=
				member2Service.checkPw(dto.getUserid(), dto.getPasswd());
		if(result) {//비밀번호 일치
			//업데이트 실행
			member2Service.updateMember(dto);
			//리스트로 주소 반환
			return "redirect:/member2/list.do";
		}else {//비밀번호 불일치
			model.addAttribute("dto", dto);
			model.addAttribute("join_date", 
					member2Service.viewMember(dto.getUserid()).getJoin_date());
			model.addAttribute("message", "비밀번호가 일치하지않습니다.");
			return "member2/view"; //forward
		}
	}//update()
	
	@RequestMapping("member2/delete.do")
	public String delete(String userid, String passwd, Model model) {
		boolean result=member2Service.checkPw(userid, passwd);
		if(result) {//����� ������ ���� => ������� �̵�
			member2Service.deleteMember(userid);
			return "redirect:/member2/list.do";
		}else {//����� Ʋ���� �ǵ��ư�
			model.addAttribute("message", "비밀번호 불일치.");
			model.addAttribute(
					"dto", member2Service.viewMember(userid));
			return "member2/view";
		}
	}//delete()

	
	
	
}
