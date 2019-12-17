package com.example.car.service.member;

import javax.servlet.http.HttpSession;

import com.example.car.model.member.dto.MemberDTO;

public interface MemberService {
	
	public boolean loginCheck(
			MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
	public MemberDTO viewMember(String userid);

}
