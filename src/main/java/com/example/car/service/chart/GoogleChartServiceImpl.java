package com.example.car.service.chart;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.car.model.shop.dto.CartDTO;
import com.example.car.service.shop.CartService;

@Service
public class GoogleChartServiceImpl implements GoogleChartService {
	
	@Inject //�������� ����(��ٱ��� ����)
	CartService cartService;

	@Override
	public JSONObject getChartData() {
		List<CartDTO> items=cartService.cartMoney();
		//������ ���� json ��ü
		JSONObject data=new JSONObject();
		//�÷��� ������ json ��ü
		JSONObject col1=new JSONObject();
		JSONObject col2=new JSONObject();
		JSONArray title=new JSONArray();
		//json�� cols ��ü����(���,���񱸼�)
		col1.put("label", "��ǰ��");
		col1.put("type", "string");
		col2.put("label", "�ݾ�");
		col2.put("type", "number");
		//json �迭�� json ��ü �߰�
		title.add(col1);
		title.add(col2);
		data.put("cols", title);
		//json�� rows ��ü����(�ٵ�,���뱸��)
		JSONArray body=new JSONArray();
		for(CartDTO dto : items) {
			JSONObject name=new JSONObject();//JSONObject�� HashMap�� ����
			name.put("v", dto.getProduct_name());
			JSONObject money=new JSONObject();
			money.put("v", dto.getMoney());
			JSONArray row=new JSONArray();
			row.add(name);
			row.add(money);
			JSONObject cell=new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);
		
		return data;
	}

}
