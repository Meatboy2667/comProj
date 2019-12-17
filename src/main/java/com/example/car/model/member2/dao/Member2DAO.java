package com.example.car.model.member2.dao;

import java.util.List;

import com.example.car.model.member2.dto.Member2DTO;

public interface Member2DAO {
	public List<Member2DTO> memberList();
	public void insertMember(Member2DTO dto);
	public Member2DTO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(Member2DTO dto);
	public boolean checkPw(String userid, String passwd);
}
