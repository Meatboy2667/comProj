package com.example.car.model.message.dao;

import com.example.car.model.message.dto.MessageDTO;

public interface MessageDAO {
//�޽��� ���� (�׽�Ʈ�� ���⸸ ��)
	public void create(MessageDTO dto);
	//�޽��� �б�
	public MessageDTO readMessage(int mid);
	//���� ����
	public void updateState(int mid);
}
