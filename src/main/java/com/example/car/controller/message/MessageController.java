package com.example.car.controller.message;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.car.model.message.dto.MessageDTO;
import com.example.car.service.message.MessageService;

@RestController //������4.0���� ��밡�� (@Controller + @ResponseBody)
@RequestMapping("messages/*") //�������� url mapping
public class MessageController {
	@Inject
	MessageService messageService;
	@RequestMapping(value="/", method=RequestMethod.POST)
	
	public ResponseEntity<String> addMessage(@RequestBody MessageDTO dto){
		//@RequestBody : Ŭ���̾�Ʈ=>����(json�����Ͱ� �Էµ� ��) ���ϰ��� json
		//@ResponseBody : ����=>Ŭ���̾�Ʈ(json), �Է°��� json
		ResponseEntity<String> entity=null;
		//ResponseEntity => ���ϰ�(json+�����޽���)
		try {
			messageService.addMessage(dto);
			//ResponseEntity => �����޽���+�����ڵ�
			entity=new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage()
					,HttpStatus.BAD_REQUEST);//400 ���� : ��ȣ�� �������� �ȸ��� ��
		}
		return entity;
	}

}
