package com.example.car.model.board2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.car.model.board2.dto.Board2DTO;

@Repository //dao bean
public class Board2DAOImpl implements Board2DAO {
	
	@Inject //의존관계 주입(Dependency Injection, DI)
	SqlSession sqlSession;

	//첨부파일 레코드 삭제
	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("board.deleteFile", fullName);
	}

	//게시물 목록 리턴
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
		map.put("fullName", fullName); //첨부파일 이름
		map.put("bno", bno); //게시물 번호
		sqlSession.insert("board.updateAttach", map);
		//게시물board는 update이지만 첨부파일attach는 기존 파일이 있다 하더라도
		//기존것은 그대로 두거나 또는 새파일을 올려 수정하는 것이기 때문에 insert()를 씀
	}

	@Override
	public void create(Board2DTO dto) throws Exception {
		sqlSession.insert("board2.insert", dto);
	}

	//레코드 수정
	@Override
	public void update(Board2DTO dto) throws Exception {
		sqlSession.update("board2.update", dto);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board2.delete", bno); 
	}

	@Override
	public List<Board2DTO> listAll(String search_option, String keyword, int start, int end) 
			throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start); //맵에 자료 저장
		map.put("end", end);
		// mapper에는 2개 이상의 값을 전달할 수 없음(dto 또는 map 사용)	
		return sqlSession.selectList("board2.listAll",map);
	}

	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("board2.increaseViewcnt", bno);
	}

	//레코드 갯수 개산
	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("board2.countArticle",map);
	}

	@Override
	public Board2DTO read(int bno) throws Exception {
		return sqlSession.selectOne("board2.read", bno);
	}
}