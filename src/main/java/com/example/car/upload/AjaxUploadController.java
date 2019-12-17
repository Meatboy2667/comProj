package com.example.car.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.car.service.board.BoardService;
import com.example.car.util.MediaUtils;
import com.example.car.util.UploadFileUtils;

@Controller
public class AjaxUploadController {
	
	//�α��� ���� ����
	private static final Logger logger 
	= LoggerFactory.getLogger(AjaxUploadController.class);
	
	@Inject
	BoardService boardSevice;
	
	
	//���ε� ���丮 servlet-context.xml�� �����Ǿ� ����
	//(value="d:/upload")
	@Resource(name = "uploadPath")
	String uploadPath; //String uploadPath="d:/upload"

	//menu.jsp���� GET������� ȣ���� ��û ó��
	//${path}/upload/uploadAjax"
	@RequestMapping(value = "/upload/uploadAjax", 
			method = RequestMethod.GET)
	public String uploadAjax() {
		return "/upload/uploadAjax";//����÷�� �������� �̵�(View�� �̸�)
	}//uploadAjax()

	//type: "post", url: "${path}/upload/uploadAjax",
	@RequestMapping(value = "/upload/uploadAjax"
			, method = RequestMethod.POST
			, produces = "text/plain;charset=utf-8")//�ѱ��� ������ �ʵ��� ó��
	
	public ResponseEntity<String> uploadAjax(MultipartFile file) 
			throws Exception {
	
		//ResponseEntity : �޽���+http �����ڵ�
		return new ResponseEntity<String>(//View�� �̸��� �ƴ϶� data��ü�� ������ ó��
				UploadFileUtils.uploadFile(uploadPath, 
						file.getOriginalFilename(), file.getBytes()),
				HttpStatus.OK);
		//������ �������ΰ� uploadAjax.jsp�� 
		//success: function(data,status,req){ ... } �Ѿ
	}//uploadAjax()
	
	@ResponseBody  //view �� �ƴ� data����
	@RequestMapping("/upload/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) 
			throws Exception {
		//������ ������ �ٿ�ε��ϱ� ���� ��Ʈ��
		InputStream in = null; //java.io
		ResponseEntity<byte[]> entity = null;
		try {
			//Ȯ���� �˻�
			String formatName = fileName.substring(
					fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			//��� ���� ��ü
			HttpHeaders headers = new HttpHeaders();
			//InputStream ����
			in = new FileInputStream(uploadPath + fileName);
			fileName = fileName.substring(fileName.indexOf("_")+1);
			//�ٿ�ε�� ����Ʈ Ÿ��
			headers.setContentType(
					MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Dispostion", 
					"attachment; filename=\"" + new String(
				fileName.getBytes("utf-8"), "iso-8859-1") + "\"");
			
			// ����Ʈ�迭(����), ���, �����ڵ� 3���� ��� ����
			entity = new ResponseEntity<byte[]>(
				IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(
					HttpStatus.BAD_REQUEST);//�������� �� �����޽��� ����
		} finally {
			if (in != null)
				in.close(); //��Ʈ�� �ݱ�
		}
		return entity;
	}//displayFile
	
	//ResponseEntity => �޽��� + �����ڵ带 ���� ó��
	@ResponseBody //�����͸� ����
	@RequestMapping(value="/upload/deleteFile"
	, method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		logger.info("fileName:"+fileName);
		//Ȯ���� �˻�
		String formatName=fileName.substring(
				fileName.lastIndexOf(".")+1);
		//������ .���� ���ں��� ������ ����
		MediaType mType=MediaUtils.getMediaType(formatName);
		if(mType != null) { //�̹��� ������ �����̹��� ����
			String front=fileName.substring(0, 12);//0~11����
			String end=fileName.substring(14);//14���� ������
			//File.separatorChar : ���н� /, �������� \
			new File(uploadPath+(front+end).replace(
					'/',File.separatorChar)).delete();
		}
		//��Ÿ���� ���� ���� ����(�̹����̸� ����� ����)
		new File(uploadPath+fileName.replace(
				'/',File.separatorChar)).delete();
		//���ڵ� ����
		boardSevice.deleteFile(fileName);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
		//uploadAjax.jsp�� if(result=="deleted")�� ����
	}
	
}
