package com.example.car.service.board2;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.car.model.board2.dto.Board2DTO;

public interface Board2Service {
	public void deleteFile(String fullName);
	public List<String> getAttach(int bno);
	public void create(Board2DTO dto) throws Exception;
	public Board2DTO read(int bno) throws Exception;
	public void update(Board2DTO dto) throws Exception;
	public void delete(int bno) throws Exception;
	public List<Board2DTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increaseViewcnt(int bno, HttpSession session) throws Exception; 
	public int countArticle(String search_option, String keyword) throws Exception;

}
