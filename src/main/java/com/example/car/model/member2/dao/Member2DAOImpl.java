package com.example.car.model.member2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.car.model.member2.dto.Member2DTO;

@Repository //���� Ŭ������ ���������� �����ϴ� dao bean���� ����
public class Member2DAOImpl implements Member2DAO {
	
	@Inject
	SqlSession sqlSession;//root-context������ id=sqlSession�� ���ƾ���.

	@Override
	public List<Member2DTO> memberList() {
		return sqlSession.selectList("member2.memberList");
		//�������� ��ü�� auto close��.
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
		//����� ������ (1), Ʋ���� (0) ����
		if(count==1) result=true;
		return result;
	}

}
