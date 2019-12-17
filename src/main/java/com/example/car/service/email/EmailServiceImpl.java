package com.example.car.service.email;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.car.model.email.EmailDTO;

@Service //���� ������ ���
public class EmailServiceImpl implements EmailService {
	
	@Inject
	JavaMailSender mailSender; //root-context.xml�� ������ bean,id���ƾ���

	@Override
	public void sendMail(EmailDTO dto) {
		try {
			//MimeMessage : �̸��� ��ü
			MimeMessage msg=mailSender.createMimeMessage();
			//�޴� ��� �̸��� �ּ� getReceiveMail()
			msg.addRecipient(RecipientType.TO, 
					new InternetAddress(dto.getReceiveMail()));
			//������ ���(�̸����ּ�+�̸�)
			msg.addFrom(new InternetAddress[] {
		new InternetAddress(dto.getSenderMail(),dto.getSenderName())
			});
			//�̸��� ����
			msg.setSubject(dto.getSubject(),"utf-8");
			//�̸��� ����
			msg.setText(dto.getMessage(),"utf-8");
			//�̸��� ������
			mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
