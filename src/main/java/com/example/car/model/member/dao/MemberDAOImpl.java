package com.example.car.model.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.car.model.member.dto.MemberDTO;

@Repository //Spring에서 관리하는 dao bean으로 설정
public class MemberDAOImpl implements MemberDAO {
	
	@Inject //mybatis 실행을 위한 SqlSession 객체 주입
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(MemberDTO dto) {
		String name = 
				sqlSession.selectOne("member.login_check", dto);
		// 조건식 ? true일때의 값 : false일 때의 값
		return (name==null) ? false : true;
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember", userid);
	}

}
