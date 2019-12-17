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
@RequestMapping("shop/product/*") //�������� url pattern
public class ProductController {
	
	@Inject //�������� ����
	ProductService productService;
	
	@RequestMapping("list.do") //�������� url pattern
	public ModelAndView list(ModelAndView mav) {
		//�������� ���� ���
		mav.setViewName("/shop/product_list");
		//������ ������
		mav.addObject("list", productService.listProduct());
		return mav;
	}//list()
	
	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(@PathVariable int product_id
			, ModelAndView mav) {
		//�������� ���� �̸�
		mav.setViewName("/shop/product_detail");
		//�信 ������ ������
		mav.addObject(
				"dto", productService.detailProduct(product_id));
		return mav;
	}//detail()
	
	@RequestMapping("write.do")
	public String write() {
		// views/shop/product_write.jsp�� �̵�
		return "shop/product_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute ProductDTO dto) {
		String filename="-";
		//÷�� ������ ������
		if(!dto.getFile1().isEmpty()) {
			//÷�� ������ �̸�
			filename=dto.getFile1().getOriginalFilename();
			try {
				//���丮������ : �������� \, ���н�(������) /
				//" "�ȿ��� \�� ���� Ư�����ڷ� �˾Ƶ�� ������ \�� �ϳ� �� �����.
				//���� ���丮
String path="D:\\work\\car\\src\\main\\webapp\\WEB-INF\\views\\images";

				//�������丮 - ���� clean 
//String path="D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\car\\WEB-INF\\views\\images";

				//���丮�� �������� ������ ����
				new File(path).mkdir();
				//�ӽ� ���丮�� ����� ÷�������� �̵�
				dto.getFile1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setPicture_url(filename);
		productService.insertProduct(dto);
		return "redirect:/shop/product/list.do";
	}//insert()
	
	// edit/6 => edit/{product_id} => ��ǰ�ڵ尡 @PathVariable�� �����
	@RequestMapping("edit/{product_id}")
	public ModelAndView edit(
			@PathVariable("product_id") int product_id, ModelAndView mav) {
		//�̵��� ���� �̸�
		mav.setViewName("shop/product_edit");
		//�信 ������ ������ ����
		mav.addObject(
				"dto", productService.detailProduct(product_id));
		return mav;
	}
	
	//��ǰ���� ����
	@RequestMapping("update.do")
	public String update(ProductDTO dto) {
		String filename="-";
		//���ο� ÷�� ������ ������
		if(!dto.getFile1().isEmpty()) {
			//÷�� ������ �̸�
			filename=dto.getFile1().getOriginalFilename();
			try {
String path="D:\\work\\car\\src\\main\\webapp\\WEB-INF\\views\\images";
				//���丮�� �������� ������ ����
				new File(path).mkdir();
				//�ӽ� ���丮�� ����� ÷�������� �̵�
				dto.getFile1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setPicture_url(filename);
		}else {//���ο� ÷�� ������ ���� ��
			//������ ÷���� ���� ������ ������
			ProductDTO dto2
			=productService.detailProduct(dto.getProduct_id());
			dto.setPicture_url(dto2.getPicture_url());
		}
		//��ǰ���� ����
		productService.updateProduct(dto);
		return "redirect:/shop/product/list.do";
	}
	
	//��ǰ ����
	@RequestMapping("delete.do")
	public String delete(@RequestParam int product_id) {
		//÷������ ����
		String filename=productService.fileInfo(product_id);
		System.out.println("÷������ �̸�:"+filename);
		if(filename != null && !filename.equals("-")) {//������ ������
String path="D:\\work\\car\\src\\main\\webapp\\WEB-INF\\views\\images";
			File f=new File(path+filename);
			System.out.println("�������翩��:"+f.exists());
			if(f.exists()) {//������ �����ϸ�
				f.delete(); //���� ����
				System.out.println("�����Ǿ����ϴ�.");
			}
		}
		//���ڵ� ����
		productService.deleteProduct(product_id);
		//ȭ�� �̵�
		return "redirect:/shop/product/list.do";
	}
	
}//end class
