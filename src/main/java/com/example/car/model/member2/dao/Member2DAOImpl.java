package com.example.car.model.member2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.car.model.member2.dto.Member2DTO;

@Repository //현재 클래스를 스프링에서 관리하는 dao bean으로 설정
public class Member2DAOImpl implements Member2DAO {
	
	@Inject
	SqlSession sqlSession;//root-context에서의 id=sqlSession과 같아야함.

	@Override
	public List<Member2DTO> memberList() {
		return sqlSession.selectList("member2.memberList");
		//스프링이 객체를 auto close함.
	}

	@Override
	public void insertMember(Member2DTO dto) {
		//auto commit, auto close
		sqlSession.insert("member2.insertMember", dto);
	}

	@Override
	public Member2DTO viewMember(String userid) {
		return sqlSession.selectOne("member2.viewMember", userid);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("member2.deleteMember", userid);
	}

	@Override
	public void updateMember(Member2DTO dto) {
		sqlSession.update("member2.updateMember", dto);
	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		boolean result=false;
		
		Map<String,String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count=sqlSession.selectOne("member2.checkPw", map);
		//비번이 맞으면 (1), 틀리면 (0) 리턴
		if(count==1) result=true;
		return result;
	}

}
