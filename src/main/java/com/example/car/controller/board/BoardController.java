package com.example.car.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.model.board.dto.BoardDTO;
import com.example.car.service.board.BoardService;
import com.example.car.service.board.Pager;

@Controller //controller bean
@RequestMapping("board/*") //�������� url pattern
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("list.do") //�������� url pattern
	//defaultValue="1" : �Ķ���Ͱ� ������ 1�� ��������
	public ModelAndView list(
			@RequestParam(defaultValue="name") String search_option,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="1") int curPage) throws Exception{
		//���ڵ� ���� ���
		int count=boardService.countArticle(search_option,keyword);//F4
		//������ ���� ����
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<BoardDTO> list
		=boardService.listAll(search_option,keyword,start,end); //�Խù� ���
		ModelAndView mav=new ModelAndView();
		HashMap<String,Object> map=new HashMap<>();
		map.put("list", list); //map�� �ڷ� ����
		map.put("count", count);
		map.put("pager", pager);//������ �׺���̼��� ���� ����
		map.put("search_option", search_option);
		map.put("keyword",keyword);
		mav.setViewName("board/list"); //�������� ���� �̸�
		mav.addObject("map", map); //ModelAndView�� map�� ����
		return mav; //board/list.jsp�� �̵�
	}//list()
	
	@RequestMapping("write.do")
	public String write() {
		//�۾��� �� �������� �̵�
		return "board/write";
	}//write()
	
	// write.jsp���� �Է��� ������� BoardDTO�� �����	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardDTO dto
			, HttpSession session)
					throws Exception {
		// �̸��� ���⶧���� ��� ���ǿ��� ����ھ��̵� ������
		String writer=(String)session.getAttribute("userid");
		dto.setWriter(writer); 
		//���ڵ� ����
		boardService.create(dto);//F4
		//�Խù� ������� �̵�
		return "redirect:/board/list.do";
	}//insert()
	
	@RequestMapping("view.do")
	public ModelAndView view(int bno, HttpSession session)
		throws Exception {
		//��ȸ�� ���� ó��
		boardService.increaseViewcnt(bno, session); 
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/view"); //�������� ���� �̸�
		mav.addObject("dto", boardService.read(bno)); //�ڷ� ����
		return mav; //  views/board/view.jsp�� �Ѿ�� ��µ�
	} 

	//÷������ ����� ����
	//ArrayList�� json �迭�� ��ȯ�Ͽ� ����
	@RequestMapping("getAttach/{bno}")
	@ResponseBody // view�� �ƴ� List<String>������ ��ü�� ���� 
	public List<String> getAttach(@PathVariable int bno){
		return boardService.getAttach(bno); //F4
	}//getAttach()	

	//�Խù� ���� ����	
	@RequestMapping("update.do")
	public String update(BoardDTO dto) throws Exception {
		System.out.println("dto:"+dto);
		if(dto != null) {
			boardService.update(dto); //���ڵ� ���� (F4)
		}
		// ���� �Ϸ� �� ������� �̵�
		//return "redirect:/board/list.do";
		// �� ȭ������ �ǵ��ư�
		return "redirect:/board/view.do?bno="+dto.getBno();
	}//update()
	
	@RequestMapping("delete.do")
	public String delete(int bno) throws Exception {
		boardService.delete(bno); //���� ó��,F4
		return "redirect:/board/list.do"; //������� �̵�
	}//delete()

	
	
	
}//end class
