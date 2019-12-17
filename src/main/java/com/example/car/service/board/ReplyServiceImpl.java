package com.example.car.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.car.model.board.dao.ReplyDAO;
import com.example.car.model.board.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	ReplyDAO replyDao;

	@Override
	public List<ReplyDTO> list(int bno) {
		return replyDao.list(bno);//
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//댓글 쓰기
	@Override
	public void create(ReplyDTO dto) {
		replyDao.create(dto);
	}

}
