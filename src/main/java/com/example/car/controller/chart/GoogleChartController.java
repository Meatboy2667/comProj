package com.example.car.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.service.chart.GoogleChartService;

@RestController //ajax => json���� ���� (������4.0 ���� ����)
//���� Controller�� �ϰԵǸ� �޼ҵ忡 @ResponseBody�� ��� json���� ����
@RequestMapping("chart/*") //���� url mapping
public class GoogleChartController {
	
	@Inject
	GoogleChartService googleChartService;	
	
	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01");
	}
	
	@RequestMapping("chart2.do")
	public ModelAndView chart2() {
		return new ModelAndView("chart/chart02");
	}

	//view(jsp)�� �Ѿ�� �ʰ� ȣ���� ���� JSONObject�� ������
	@RequestMapping("cart_money_list.do")
	public JSONObject cart_money_list() {
		return googleChartService.getChartData();
	}

}
