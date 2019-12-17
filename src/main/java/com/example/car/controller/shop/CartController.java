package com.example.car.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.model.shop.dto.CartDTO;
import com.example.car.service.shop.CartService;

@Controller
@RequestMapping("shop/cart/*") //�������� url mapping
public class CartController {
	
	@Inject
	CartService cartService;
	
	@RequestMapping("list.do")
	public ModelAndView list(
			HttpSession session, ModelAndView mav) {
		Map<String, Object> map = new HashMap();
		//���Ǻ��� Ȯ��
		String userid = (String)session.getAttribute("userid");
		if (userid != null) {//�α����� ���
			List<CartDTO> list = cartService.listCart(userid);
			//��ٱ��� �հ� ���
			int sumMoney = cartService.sumMoney(userid);
			//��۷� ���
			int fee = sumMoney >= 30000 ? 0 : 2500; //�հ�3���� �̻��̸� ��۷� 0
			map.put("sumMoney", sumMoney);//��ٱ��� �ݾ� �հ�
			map.put("fee", fee); //��۷�
			map.put("sum", sumMoney + fee); //���հ�ݾ�
			
			map.put("list", list); //�ʿ� �ڷ� �߰�
			map.put("count", list.size());
			mav.setViewName("shop/cart_list"); //jsp ������ �̸�
			mav.addObject("map", map); //jsp�� ������ ������
			return mav;
		} else { //�α������� ���� ��� userid <- null
			return new ModelAndView("member/login", "", null);
		}
	}//list()
	
	
	@RequestMapping("insert.do") //�������� url mapping
	public String insert(HttpSession session
			, @ModelAttribute CartDTO dto) {
		//���ǿ� userid ������ �����ϴ��� Ȯ��
		String userid = (String)session.getAttribute("userid");
		//if (userid == null) { //�α��� ���� ���� ����
		//	return "redirect:/member/login.do"; //�α��� ��������
		//}
		//��ٱ��Ͽ� insert ó�� �� ��ٱ��� ������� �̵�
		dto.setUserid(userid);
		cartService.insert(dto);
		return "redirect:/shop/cart/list.do";
	}//insert()
	
	//��ٱ��� ���� ��ǰ ����
	//@RequestParam : request.getParameter()
	//@ModelAttribute : �������� ��ü�� dto�� ����
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cart_id
			, HttpSession session) {
		if(session.getAttribute("userid") != null)
			cartService.delete(cart_id);
		return "redirect:/shop/cart/list.do";
	}
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		// ���Ǻ��� ��ȸ(�α��� ���� �˻�)
		String userid = (String)session.getAttribute("userid");
		if (userid != null) {//�α����� �����̸�
			//��ٱ��ϸ� ����
			cartService.deleteAll(userid);
		}
		//��ٱ��� ������� �̵�
		return "redirect:/shop/cart/list.do";
	}

	@RequestMapping("update.do")
	public String update(@RequestParam int[] amount
			, @RequestParam int[] cart_id, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		if (userid != null) {
			//hidden���� �Ѿ���� cart_id�� �迭������ �Ѿ�´�.
			//���� ArrayList �Ǵ� �迭�� ó���ؾ��Ѵ�. 
			for (int i=0; i < cart_id.length; i++) {
				if (amount[i] == 0) { //������ 0�̸� ���ڵ� ����
					cartService.delete(cart_id[i]);
				} else { //0�� �ƴϸ� ����
					CartDTO dto = new CartDTO();
					dto.setUserid(userid);
					dto.setCart_id(cart_id[i]);
					dto.setAmount(amount[i]);
					cartService.modifyCart(dto);
				}
			}
			
		}//end if
		return "redirect:/shop/cart/list.do";
	}
	

}//end class
