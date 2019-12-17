package com.example.car.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.service.chart.GoogleChartService;

@RestController //ajax => json으로 리턴 (스프링4.0 부터 지원)
//만약 Controller로 하게되면 메소드에 @ResponseBody를 써야 json으로 리턴
@RequestMapping("chart/*") //공통 url mapping
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

	//view(jsp)로 넘어가지 않고 호출한 곳에 JSONObject를 리턴함
	@RequestMapping("cart_money_list.do")
	public JSONObject cart_money_list() {
		return googleChartService.getChartData();
	}

}
