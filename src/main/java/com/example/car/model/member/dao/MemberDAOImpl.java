package com.example.car.model.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.car.model.member.dto.MemberDTO;

@Repository //Spring���� �����ϴ� dao bean���� ����
public class MemberDAOImpl implements MemberDAO {
	
	@Inject //mybatis ������ ���� SqlSession ��ü ����
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(MemberDTO dto) {
		String name = 
				sqlSession.selectOne("member.login_check", dto);
		// ���ǽ� ? true�϶��� �� : false�� ���� ��
		return (name==null) ? false : true;
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember", userid);
	}

}
