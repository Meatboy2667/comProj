package com.example.car.model.board2.dao;

import java.util.List;

import com.example.car.model.board2.dto.Board2DTO;

public interface Board2DAO {
	public void deleteFile(String fullName); //첨부파일 삭제
	public List<String> getAttach(int bno); //첨부파일 정보
	public void addAttach(String fullName); //첨부파일 저장
	//첨부파일 수정
	public void updateAttach(String fullName, int bno);
	public void create(Board2DTO dto) throws Exception; //글쓰기 
	public void update(Board2DTO dto) throws Exception; //글수정
	public void delete(int bno) throws Exception; //글삭제
	//목록
	public List<Board2DTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	//조회수 증가 처리
	public void increateViewcnt(int bno) throws Exception;
	//레코드 갯수 계산 
	public int countArticle(String search_option, String keyword) throws Exception;
	//레코드 조회
	public Board2DTO read(int bno) throws Exception;	
	

}
