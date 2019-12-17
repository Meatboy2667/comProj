package com.example.car.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.car.model.board.dto.BoardDTO;

@Repository //dao bean
public class BoardDAOImpl implements BoardDAO {
	
	@Inject //�������� ����(Dependency Injection, DI)
	SqlSession sqlSession;

	//÷������ ���ڵ� ����
	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("board.deleteFile", fullName);
	}

	//�Խù� ��� ����
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("board.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("board.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //÷������ �̸�
		map.put("bno", bno); //�Խù� ��ȣ
		sqlSession.insert("board.updateAttach", map);
		//�Խù�board�� update������ ÷������attach�� ���� ������ �ִ� �ϴ���
		//�������� �״�� �ΰų� �Ǵ� �������� �÷� �����ϴ� ���̱� ������ insert()�� ��
	}

	@Override
	public void create(BoardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}

	//���ڵ� ����
	@Override
	public void update(BoardDTO dto) throws Exception {
		sqlSession.update("board.update", dto);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.delete", bno); 
	}

	@Override
	public List<BoardDTO> listAll(String search_option, String keyword, int start, int end) 
			throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start); //�ʿ� �ڷ� ����
		map.put("end", end);
		// mapper���� 2�� �̻��� ���� ������ �� ����(dto �Ǵ� map ���)	
		return sqlSession.selectList("board.listAll",map);
	}

	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("board.increaseViewcnt", bno);
	}

	//���ڵ� ���� ����
	@Override
	public int countArticle(String search_option, String keyword) 
			throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("board.countArticle",map);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("board.read", bno);
	}

}
