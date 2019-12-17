package com.example.car.controller.road;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("road/*")
public class RoadController {
	
	/*@Inject
	RoadService roadService;*/
	
	@RequestMapping("list.do")
	public String list() {
		return "road/road";
	}
}
