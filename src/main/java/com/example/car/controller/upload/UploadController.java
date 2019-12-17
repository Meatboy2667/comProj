package com.example.car.controller.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	//�α��� ���� �ڵ�
	private static final Logger logger
	= LoggerFactory.getLogger(UploadController.class);

	//servlet-context.xml�� ������ ��Ʈ�� bean ����
	@Resource(name="uploadPath")
	String uploadPath;

	//���ε� �� �������� �̵�
	@RequestMapping(value="/upload/uploadForm"
			,method=RequestMethod.GET)
	public String uploadForm() {
		//  views/upload/uploadForm.jsp
		return "upload/uploadForm";
	}

	
	//���ε�� ������ ó��
	//MultipartFile file : ���ε��� ������ ����� (�ӽð��)
	@RequestMapping(value="/upload/uploadForm"
			,method=RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file
			,ModelAndView mav) throws Exception {
		String savedName=file.getOriginalFilename();
		savedName = uploadFile(savedName, file.getBytes());
		mav.setViewName("upload/uploadResult"); //���� �̸�
		mav.addObject("savedName", savedName); //������ ������
		return mav;
	}
	String uploadFile(String originalName, byte[] fileData)
			throws Exception {
		// Universal Unique IDentifier, ��������ĺ���
     // �ߺ��������� �ö� ��� �������� �ڵ������� �ٸ��̸��� ������ ���ε��Ų��.
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString()+"_"+originalName;
		// new File(���丮, �����̸�)
		File target=new File(uploadPath, savedName);//import java.io.File;
		//÷�������� �ӽõ��丮���� �츮�� ������ ���丮�� ����
		FileCopyUtils.copy(fileData, target);
		return savedName;

	}
	
	
	

}
