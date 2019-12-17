package com.example.car.controller.pdf;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.service.pdf.PdfService;

@Controller //��Ʈ�ѷ� ������ ���
@RequestMapping("pdf/*") //�������� url mapping
public class PdfController {
	
	@Inject
	PdfService pdfService;
	
	@RequestMapping("list.do") //�������� url mapping
	public ModelAndView list() throws Exception {
		//pdf ���� ����
		String result=pdfService.createPdf();
		//ȭ�� �̵�
		return new ModelAndView("pdf/result", "message", result);
	}
}
