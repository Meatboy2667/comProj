package com.example.car.service.message;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.car.model.message.dao.MessageDAO;
import com.example.car.model.message.dao.PointDAO;
import com.example.car.model.message.dto.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService {
	
	//Inject�� ��ü�� ���� �ؾ� ��.
	@Inject
	MessageDAO messageDao;
	@Inject
	PointDAO pointDao;
	
	//Ʈ����� ó�� ��� method
	@Transactional
	@Override
	public void addMessage(MessageDTO dto) {
		//�޽����� ���̺� ����
		messageDao.create(dto);
		//�޽����� ���� ȸ������ 10����Ʈ �߰�
		pointDao.updatePoint(dto.getSender(), 10);
	}

	@Override
	public MessageDTO readMessage(String userid, int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
