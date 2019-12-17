package com.example.car.controller.email;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.car.model.email.EmailDTO;
import com.example.car.service.email.EmailService;

@Controller
@RequestMapping("email/*")
public class EmailController {
	@Inject
	EmailService emailService;
	
	@RequestMapping("write.do")
	public String write() {
		return "/email/write";
	}
	
	@RequestMapping("send.do")
	public String send(@ModelAttribute EmailDTO dto, Model model) {
		try {
			emailService.sendMail(dto);
			model.addAttribute("message","�̸����� �߼۵Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message","�̸��� �߼� ����...");
		}
		return "/email/write";
	}
	
	

}
