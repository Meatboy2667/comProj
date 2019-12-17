package com.example.car.service.message;

import com.example.car.model.message.dto.MessageDTO;

public interface MessageService {
public void addMessage(MessageDTO dto);
public MessageDTO readMessage(String userid, int mid);
	
}
