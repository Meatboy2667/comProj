package com.example.car.model.member.dao;

import com.example.car.model.member.dto.MemberDTO;

public interface MemberDAO {
	public boolean loginCheck(MemberDTO dto);
	public MemberDTO viewMember(String userid);

}
