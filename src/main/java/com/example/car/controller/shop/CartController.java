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
@RequestMapping("shop/cart/*") //공통적인 url mapping
public class CartController {
	
	@Inject
	CartService cartService;
	
	@RequestMapping("list.do")
	public ModelAndView list(
			HttpSession session, ModelAndView mav) {
		Map<String, Object> map = new HashMap();
		//세션변수 확인
		String userid = (String)session.getAttribute("userid");
		if (userid != null) {//로그인한 경우
			List<CartDTO> list = cartService.listCart(userid);
			//장바구니 합계 계산
			int sumMoney = cartService.sumMoney(userid);
			//배송료 계산
			int fee = sumMoney >= 30000 ? 0 : 2500; //합계3만원 이상이며 배송료 0
			map.put("sumMoney", sumMoney);//장바구니 금액 합계
			map.put("fee", fee); //배송료
			map.put("sum", sumMoney + fee); //총합계금액
			
			map.put("list", list); //맵에 자료 추가
			map.put("count", list.size());
			mav.setViewName("shop/cart_list"); //jsp 페이지 이름
			mav.addObject("map", map); //jsp에 전달할 데이터
			return mav;
		} else { //로그인하지 않은 경우 userid <- null
			return new ModelAndView("member/login", "", null);
		}
	}//list()
	
	
	@RequestMapping("insert.do") //세부적인 url mapping
	public String insert(HttpSession session
			, @ModelAttribute CartDTO dto) {
		//세션에 userid 변수가 존재하는지 확인
		String userid = (String)session.getAttribute("userid");
		//if (userid == null) { //로그인 하지 않은 상태
		//	return "redirect:/member/login.do"; //로그인 페이지로
		//}
		//장바구니에 insert 처리 후 장바구니 목록으로 이동
		dto.setUserid(userid);
		cartService.insert(dto);
		return "redirect:/shop/cart/list.do";
	}//insert()
	
	//장바구니 개별 상품 삭제
	//@RequestParam : request.getParameter()
	//@ModelAttribute : 폼데이터 전체를 dto로 저장
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cart_id
			, HttpSession session) {
		if(session.getAttribute("userid") != null)
			cartService.delete(cart_id);
		return "redirect:/shop/cart/list.do";
	}
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		// 세션변수 조회(로그인 여부 검사)
		String userid = (String)session.getAttribute("userid");
		if (userid != null) {//로그인한 상태이면
			//장바구니를 비우고
			cartService.deleteAll(userid);
		}
		//장바구니 목록으로 이동
		return "redirect:/shop/cart/list.do";
	}

	@RequestMapping("update.do")
	public String update(@RequestParam int[] amount
			, @RequestParam int[] cart_id, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		if (userid != null) {
			//hidden으로 넘어오는 cart_id는 배열값으로 넘어온다.
			//따라서 ArrayList 또는 배열로 처리해야한다. 
			for (int i=0; i < cart_id.length; i++) {
				if (amount[i] == 0) { //수량이 0이면 레코드 삭제
					cartService.delete(cart_id[i]);
				} else { //0이 아니면 수정
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
