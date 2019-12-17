package com.example.car.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.car.model.board.dao.BoardDAO;
import com.example.car.model.board.dto.BoardDTO;

@Service //service bean
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;

	@Override
	public void deleteFile(String fullName) {
		boardDao.deleteFile(fullName);//F4
	}

	@Override
	public List<String> getAttach(int bno) {
		return boardDao.getAttach(bno);
	}

	//1. �۾��� - �Խù� ��ȣ ����
	//2. ÷������ ��� - �Խù� ��ȣ ���
	@Transactional
	@Override
	public void create(BoardDTO dto) throws Exception {
		//board ���̺� ���ڵ� �߰�
		boardDao.create(dto); 
		//attach ���̺� ���ڵ� �߰�
		String[] files=dto.getFiles(); //÷������ �̸� �迭
		if(files==null) return;  //÷�������� ������ skip
		for(String name : files) {
			boardDao.addAttach(name);//attach ���̺� insert, F4
		}
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		return boardDao.read(bno);
	}

	@Transactional //Ʈ����� ó�� method
	@Override
	public void update(BoardDTO dto) throws Exception {
		boardDao.update(dto); //board ���̺� ����, F4
		//������ ������� ����ó�� attach ���̺� �����������,���� ����ó����.
		//���� board �� attach�� transaction ó���� �������.
    //service�� transaction���� ���⿡ �� �� �����ϴ�.
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			System.out.println("÷������ �̸�:"+name);
			boardDao.updateAttach(name, dto.getBno());//F4
		}
	}


	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		//reply ���ڵ� ����
		//attach ���ڵ� ����
		//÷������ ����
		//board ���ڵ� ����
		boardDao.delete(bno); 
	}

	@Override
	public List<BoardDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return boardDao.listAll(search_option,keyword,start,end);
	}

	//��ȸ�� ���� ó��
	@Override
	public void increaseViewcnt(int bno, HttpSession session)
			throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno)!=null) {
			//�ֱٿ� ��ȸ���� �ø� �ð�
			update_time=
					(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		//���� �ð�(5��)�� ����� �� ��ȸ�� ���� ó��
		if(current_time - update_time > 5*1000) {//24*60*60*1000(�Ϸ�)
			boardDao.increateViewcnt(bno);
			//��ȸ���� �ø� �ð� ����
			session.setAttribute("update_time_"+bno, current_time);

		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return boardDao.countArticle(search_option,keyword);//F4
	}

}
