package com.example.car.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.model.memo.dto.MemoDTO;
import com.example.car.service.memo.MemoService;

//스프링에게 컨트롤러임을 명시해줌
@Controller
@RequestMapping("memo/*") //공통적인 url pattern
public class MemoController {
	
	@Inject //의존관계 주입
	MemoService memoService;
	
	//http://localhost/car/memo/list.do
	//http://localhost/car/memo/insert.do
	//http://localhost/car/memo/update.do
	@RequestMapping("list.do") //세부적인 url pattern
	public ModelAndView list(ModelAndView mav) {
		List<MemoDTO> items=memoService.list();
		// /WEB-INF/views/memo/memo_list.jsp
		mav.setViewName("memo/memo_list");//포워딩할 뷰의 이름
		mav.addObject("list", items); //전달할 데이터(모델)
		return mav; 
		//return new MedelAndView("memo/memo_list", "list",items);
	}//list()
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemoDTO dto) {
		memoService.insert(dto);
		return "redirect:/memo/list.do";
	}//insert()
	
	@RequestMapping("view/{idx}")
	public ModelAndView view(@PathVariable int idx, 
			ModelAndView mav) {
		//포워딩할 뷰의 이름
		mav.setViewName("memo/view");
		//전달할 데이터
		mav.addObject("dto", memoService.memo_view(idx));
		return mav;
	}//view()
	
	@RequestMapping("update/{idx}")
	public String update(@PathVariable int idx, 
			@ModelAttribute MemoDTO dto) {
		//메모 수정
		memoService.update(dto);//F4
		//수정 완료 후 목록으로 이동
		return "redirect:/memo/list.do";
	}//update()
	
	@RequestMapping("delete/{idx}")
	public String delete(@PathVariable int idx) {
		//레코드 삭제 처리
		memoService.delete(idx);
		//삭제 완료 후 목록으로 이동
		return "redirect:/memo/list.do";
	}
	

}
