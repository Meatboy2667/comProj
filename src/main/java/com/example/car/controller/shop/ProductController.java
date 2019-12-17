package com.example.car.controller.shop;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.car.model.shop.dto.ProductDTO;
import com.example.car.service.shop.ProductService;

@Controller
@RequestMapping("shop/product/*") //공통적인 url pattern
public class ProductController {
	
	@Inject //의존관계 주입
	ProductService productService;
	
	@RequestMapping("list.do") //세부적인 url pattern
	public ModelAndView list(ModelAndView mav) {
		//포워딩할 뷰의 경로
		mav.setViewName("/shop/product_list");
		//전달할 데이터
		mav.addObject("list", productService.listProduct());
		return mav;
	}//list()
	
	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(@PathVariable int product_id
			, ModelAndView mav) {
		//포워딩할 뷰의 이름
		mav.setViewName("/shop/product_detail");
		//뷰에 전달할 데이터
		mav.addObject(
				"dto", productService.detailProduct(product_id));
		return mav;
	}//detail()
	
	@RequestMapping("write.do")
	public String write() {
		// views/shop/product_write.jsp로 이동
		return "shop/product_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute ProductDTO dto) {
		String filename="-";
		//첨부 파일이 있으면
		if(!dto.getFile1().isEmpty()) {
			//첨부 파일의 이름
			filename=dto.getFile1().getOriginalFilename();
			try {
				//디렉토리구분자 : 윈도우즈 \, 유닉스(리눅스) /
				//" "안에다 \를 쓰면 특수문자로 알아듣기 때문에 \를 하나 더 써야함.
				//개발 디렉토리
String path="D:\\work\\car\\src\\main\\webapp\\WEB-INF\\views\\images";

				//배포디렉토리 - 서버 clean 
//String path="D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\car\\WEB-INF\\views\\images";

				//디렉토리가 존재하지 않으면 생성
				new File(path).mkdir();
				//임시 디렉토리에 저장된 첨부파일을 이동
				dto.getFile1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setPicture_url(filename);
		productService.insertProduct(dto);
		return "redirect:/shop/product/list.do";
	}//insert()
	
	// edit/6 => edit/{product_id} => 상품코드가 @PathVariable에 저장됨
	@RequestMapping("edit/{product_id}")
	public ModelAndView edit(
			@PathVariable("product_id") int product_id, ModelAndView mav) {
		//이동할 뷰의 이름
		mav.setViewName("shop/product_edit");
		//뷰에 전달할 데이터 저장
		mav.addObject(
				"dto", productService.detailProduct(product_id));
		return mav;
	}
	
	//상품정보 수정
	@RequestMapping("update.do")
	public String update(ProductDTO dto) {
		String filename="-";
		//새로운 첨부 파일이 있으면
		if(!dto.getFile1().isEmpty()) {
			//첨부 파일의 이름
			filename=dto.getFile1().getOriginalFilename();
			try {
String path="D:\\work\\car\\src\\main\\webapp\\WEB-INF\\views\\images";
				//디렉토리가 존재하지 않으면 생성
				new File(path).mkdir();
				//임시 디렉토리에 저장된 첨부파일을 이동
				dto.getFile1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setPicture_url(filename);
		}else {//새로운 첨부 파일이 없을 때
			//기존에 첨부한 파일 정보를 가져옴
			ProductDTO dto2
			=productService.detailProduct(dto.getProduct_id());
			dto.setPicture_url(dto2.getPicture_url());
		}
		//상품정보 수정
		productService.updateProduct(dto);
		return "redirect:/shop/product/list.do";
	}
	
	//상품 삭제
	@RequestMapping("delete.do")
	public String delete(@RequestParam int product_id) {
		//첨부파일 삭제
		String filename=productService.fileInfo(product_id);
		System.out.println("첨부파일 이름:"+filename);
		if(filename != null && !filename.equals("-")) {//파일이 있으면
String path="D:\\work\\car\\src\\main\\webapp\\WEB-INF\\views\\images";
			File f=new File(path+filename);
			System.out.println("파일존재여부:"+f.exists());
			if(f.exists()) {//파일이 존재하면
				f.delete(); //파일 삭제
				System.out.println("삭제되었습니다.");
			}
		}
		//레코드 삭제
		productService.deleteProduct(product_id);
		//화면 이동
		return "redirect:/shop/product/list.do";
	}
	
}//end class
