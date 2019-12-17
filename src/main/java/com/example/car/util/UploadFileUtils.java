package com.example.car.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(String uploadPath, 
			String originalName, byte[] fileData) throws Exception {
		// uuid �߱�
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		//���ε��� ���丮 ����
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		//�ӽ� ���丮�� ���ε�� ������ ������ ���丮�� ����
		FileCopyUtils.copy(fileData, target);
		//������ Ȯ���� �˻�(.���� ������ �̸��� Ȯ�������� Ȱ��)
		// a.jpg  aaa.bbb.ccc.jpg
		String formatName = 
				originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadedFileName = null;
		// �̹��� ������ �����(���� �̹���) ���
		if (MediaUtils.getMediaType(formatName) != null) {
			//����� ����
			uploadedFileName = makeThumbnail(uploadPath, 
					savedPath, savedName);
		} else {
			uploadedFileName = makeIcon(uploadPath, savedPath, 
					savedName);
		}
		return uploadedFileName;
	}//uploadFile()
	
	//����� �̹���(������) ����,
	private static String makeIcon(String uploadPath, 
			String path, String fileName) throws Exception {
		//�������� �̸�
		String iconName = uploadPath + path + File.separator + fileName;
		//������ �̸��� ����
		//File.separator : ���丮 ������
		// ������ \, ���н�(������) /
		return iconName.substring(uploadPath.length()).
				replace(File.separatorChar, '/');
	}
	
	private static String makeThumbnail(String uploadPath, 
			String path, String fileName) throws Exception {
		//�̹����� �б� ���� ����
		BufferedImage sourceImg = ImageIO.read(
				new File(uploadPath + path, fileName));
		//100�ȼ� ���� ����� ����
		BufferedImage destImg = Scalr.resize(
				sourceImg, Scalr.Method.AUTOMATIC, 
				Scalr.Mode.FIT_TO_HEIGHT, 100);
		//������� �̸�
		String thumbailName = uploadPath + 
				path + File.separator + "s_" + fileName;
		File newFile = new File(thumbailName);
		String formatName = fileName.substring(
				fileName.lastIndexOf(".") + 1);
		//����� ����
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		//������� �̸��� ������
		return thumbailName.substring(
				uploadPath.length()).replace(File.separatorChar, '/');
	}//makeThumbnail()

	//��¥ó��(��, 00�� 00��)
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator 
				+ new DecimalFormat("00").format(
						cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator 
				+ new DecimalFormat("00").format(
						cal.get(Calendar.DATE));
		//���丮 ���� �޼ҵ� ȣ��
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);
		return datePath;
	}
	
	//���丮 ����
	private static void makeDir(String uploadPath, String... paths) {
		//String...�� ���������� �Ű����� (�迭�� ��Ұ� ��� ������� ó��)
		//���丮�� �����ϸ� skip
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdirs(); //���丮 ����
			}
		}
	}
}
