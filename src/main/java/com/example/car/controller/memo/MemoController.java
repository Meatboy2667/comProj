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

//���������� ��Ʈ�ѷ����� �������
@Controller
@RequestMapping("memo/*") //�������� url pattern
public class MemoController {
	
	@Inject //�������� ����
	MemoService memoService;
	
	//http://localhost/car/memo/list.do
	//http://localhost/car/memo/insert.do
	//http://localhost/car/memo/update.do
	@RequestMapping("list.do") //�������� url pattern
	public ModelAndView list(ModelAndView mav) {
		List<MemoDTO> items=memoService.list();
		// /WEB-INF/views/memo/memo_list.jsp
		mav.setViewName("memo/memo_list");//�������� ���� �̸�
		mav.addObject("list", items); //������ ������(��)
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
		//�������� ���� �̸�
		mav.setViewName("memo/view");
		//������ ������
		mav.addObject("dto", memoService.memo_view(idx));
		return mav;
	}//view()
	
	@RequestMapping("update/{idx}")
	public String update(@PathVariable int idx, 
			@ModelAttribute MemoDTO dto) {
		//�޸� ����
		memoService.update(dto);//F4
		//���� �Ϸ� �� ������� �̵�
		return "redirect:/memo/list.do";
	}//update()
	
	@RequestMapping("delete/{idx}")
	public String delete(@PathVariable int idx) {
		//���ڵ� ���� ó��
		memoService.delete(idx);
		//���� �Ϸ� �� ������� �̵�
		return "redirect:/memo/list.do";
	}
	

}
