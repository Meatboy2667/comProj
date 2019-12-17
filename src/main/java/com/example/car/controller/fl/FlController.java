package com.example.car.controller.fl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fl/*")
public class FlController {
	
	@RequestMapping("tos.do")
	public String tos() {
		return "fl/tos";
	}
	
	@RequestMapping("privacy.do")
	public String privacy() {
		return "fl/privacy";
	}
}
