package com.example.car.service.member2;

import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.car.model.member2.dao.Member2DAO;
import com.example.car.model.member2.dto.Member2DTO;

//현재클래스를 스프링에서 관리하는 service bean으로 설정
//1개의 Service가 1개 또는 여러개의 dao를 다룬다.
@Service 
public class Member2ServiceImpl implements Member2Service {

	//dao 인스턴스를 주입시킴
	@Inject
	Member2DAO member2Dao;
	//Member2DAO member2Dao=new Member2DAOImpl();

	@Override
	public List<Member2DTO> memberList() {
		return member2Dao.memberList();
	}

	@Override
	public void insertMember(Member2DTO dto) {
		member2Dao.insertMember(dto);
	}

	@Override
	public Member2DTO viewMember(String userid) {
		return member2Dao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		member2Dao.deleteMember(userid);
	}

	@Override
	public void updateMember(Member2DTO dto) {
		member2Dao.updateMember(dto);
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		return member2Dao.checkPw(userid, passwd);
	}

}
