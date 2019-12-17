package com.example.car.controller.board2;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.model.board.dto.ReplyDTO;
import com.example.car.service.board.ReplyService;

//@ResponseBody�� ������ �ʾƵ� �䰡 �ƴ� ������ ���� ����
@RestController // spring 4.0���� ��� ����
@RequestMapping("reply2/*") //�������� url pattern
public class Reply2Controller {
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do") //�������� url pattern
	public void insert(ReplyDTO dto, HttpSession session) {
		//���ǿ� ����� ��� �ۼ��� ���̵� ������ ó��
		String userid=(String)session.getAttribute("userid");
		dto.setReplyer(userid);
		//����� ���̺� �����
		replyService.create(dto);
		//Ajax�� �����ѱ�� �����⶧���� jsp �������� ���ų� �����͸� �������� ����
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(int bno, ModelAndView mav) {
		List<ReplyDTO> list=replyService.list(bno); //��� ���,F4
		mav.setViewName("board/reply_list"); //���� �̸�
		mav.addObject("list", list); //�信 ������ ������ ����
		return mav; //��� �̵�
	}//list()

	//��� ����� ArrayList�� ����
	@RequestMapping("list_json.do")
	public List<ReplyDTO> list_json(int bno){
		return replyService.list(bno);
	}//list_json()	


}
