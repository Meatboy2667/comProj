package com.example.car.controller.chart;

import java.io.FileOutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.service.chart.JFreeChartService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

@Controller //Controller bean ���� ���
@RequestMapping("jchart/*") //�������� url mapping
public class JFreeChartController {
	@Inject
	JFreeChartService chartService;
	@RequestMapping("chart1.do") //�������� url mapping
	public void createChart1(HttpServletResponse response) {
		try {
			//��Ʈ ��ü ����
			JFreeChart chart=chartService.createChart();
			//��Ʈ�� png�̹����� export
			//writeChartAsPNG(��½�Ʈ��, ��Ʈ��ü, ����, ����)
			ChartUtilities.writeChartAsPNG(
					response.getOutputStream(), chart, 900, 550);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}//createChart1()
	@RequestMapping("chart2.do")
	public ModelAndView createChart2(HttpServletResponse response) {
		String message="";
		try {
			//��Ʈ ��ü ����
			JFreeChart chart=chartService.createChart();
			//pdf���� ��ü
			Document document=new Document(); //import com.itextpdf.tex..........
			//pdf ���� ��ü
			PdfWriter.getInstance(document, new FileOutputStream("d:/test.pdf"));
			document.open();

			Image png=Image.getInstance(ChartUtilities.encodeAsPNG(chart.createBufferedImage(500, 500)));
			//pdf ������ �̹����� �߰� 
			document.add(png);
			//pdf ������ �����
			document.close();
			message="pdf 파일이 생성되었습니다.";

		} catch (Exception e) {
			message="pdf 파일 생성 실패...";
			e.printStackTrace();
		}
		return new ModelAndView("chart/jchart02","message",message);
	}

}//end class
