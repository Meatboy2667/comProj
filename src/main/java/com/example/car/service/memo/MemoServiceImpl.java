package com.example.car.service.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.car.model.memo.dao.MemoDAO;
import com.example.car.model.memo.dto.MemoDTO;

//��Ʈ�ѷ����� ��Ŭ������ Service Ŭ�������� ���
@Service
public class MemoServiceImpl implements MemoService {
	
	@Inject //�������� ����(���������� �ν��Ͻ� ����)
	MemoDAO memoDao;

	@Override
	public List<MemoDTO> list() {
		return memoDao.list();//list()�� �ϼ��� �������̽��� �ƴѵ���
		//�� �� �ִ� ������ �������� root-context.xml���� mybatis��ü��
		//�޸𸮿� �÷� ���ÿ� ���� ������ ��ü�� �ڵ� ���ս�Ű��
		//ArrayList�� �޾� ó���Ѵ�.
	}

	@Override
	public void insert(MemoDTO dto) {
		memoDao.insert(dto.getWriter(), dto.getMemo());
	}

	@Override
	public MemoDTO memo_view(int idx) {
		return memoDao.memo_view(idx);
	}

	@Override
	public void update(MemoDTO dto) {
		memoDao.update(dto);
	}

	@Override
	public void delete(int idx) {
		memoDao.delete(idx);
	}
}
