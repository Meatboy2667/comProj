package com.example.car.controller.list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("list/*") //�������� url mapping
public class ListController {
	@RequestMapping("g1.do") //�������� url mapping
	public String g1() {
		return "list/g1"; //views/list/g.jsp�� �̵�
	}//g()
	
	
	@RequestMapping("g2.do") //�������� url mapping
	public String g2() {
		return "list/g2"; //views/list/g.jsp�� �̵�
		
		
	}//g()
	
	@RequestMapping("g3.do") //�������� url mapping
	public String g3() {
		return "list/g3"; //views/list/g.jsp�� �̵�
		
		
	}//g()
	@RequestMapping("f1.do") //�������� url mapping
	public String f1() {
		return "list/f1"; //views/list/g.jsp�� �̵�
		
		
	}//g()
	@RequestMapping("f2.do") //�������� url mapping
	public String f2() {
		return "list/f2"; //views/list/g.jsp�� �̵�
		
		
	}//g()
	@RequestMapping("f3.do") //�������� url mapping
	public String f3() {
		return "list/f3"; //views/list/g.jsp�� �̵�
		
		
	}//g()	
	@RequestMapping("e1.do") //�������� url mapping
	public String e1() {
		return "list/e1"; //views/list/g.jsp�� �̵�
	}//g()
	@RequestMapping("e2.do") //�������� url mapping
	public String e2() {
		return "list/e2"; //views/list/g.jsp�� �̵�
		
		
	}//g()
	@RequestMapping("e3.do") //�������� url mapping
	public String e3() {
		return "list/e3"; //views/list/g.jsp�� �̵�
		
		
	}//g()
	@RequestMapping("c1.do") //�������� url mapping
	public String c1() {
		return "list/c1"; //views/list/g.jsp�� �̵�
	}//g()
	@RequestMapping("c2.do") //�������� url mapping
	public String c2() {
		return "list/c2"; //views/list/g.jsp�� �̵�
	}//g()
	@RequestMapping("c3.do") //�������� url mapping
	public String c3() {
		return "list/c3"; //views/list/g.jsp�� �̵�
	}//g()
	@RequestMapping("d1.do") //�������� url mapping
	public String d1() {
		return "list/d1"; //views/list/g.jsp�� �̵�
	}//g()
	@RequestMapping("d2.do") //�������� url mapping
	public String d2() {
		return "list/d2"; //views/list/g.jsp�� �̵�
	}//g()
	@RequestMapping("d3.do") //�������� url mapping
	public String d3() {
		return "list/d3"; //views/list/g.jsp�� �̵�
	}//g()
	

}
