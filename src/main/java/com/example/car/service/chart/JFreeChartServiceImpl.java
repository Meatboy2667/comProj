package com.example.car.service.chart;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.inject.Inject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import com.example.car.model.shop.dao.CartDAO;
import com.example.car.model.shop.dto.CartDTO;


@Service //Service bean���� ���
public class JFreeChartServiceImpl implements JFreeChartService {

	@Inject //�������� ����(DI)
	CartDAO cartDao;
	
	@Override
	public JFreeChart createChart() {
		//��ٱ��� ��ǰ ���
		List<CartDTO> list=cartDao.cartMoney();
		//������Ʈ�� �����ͼ� ����
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(CartDTO dto : list) {
			dataset.setValue(dto.getProduct_name(), dto.getMoney());
		}
		
		//��Ʈ�� �Է��� �����ͼ� ��ü(������Ʈ�� �ƴ� ���)
/*		DefaultCategoryDataset dataset
		  =new DefaultCategoryDataset();
		for(CartDTO dto : list) {
			dataset.setValue(
					dto.getMoney(), "����", dto.getProduct_name());
		}*/
		
		//��Ʈ ��ü
		JFreeChart chart=null;
		String title="��ٱ��� ���"; //��Ʈ ����
		try {
			//���� �׷���
			//createBarChart(����,x���,y���,�����ͼ�,�׷�������,
			//����,����,url)
/*			chart=ChartFactory.createBarChart(title, "��ǰ��", 
					"�ݾ�", dataset, PlotOrientation.VERTICAL,
					true,true,false);*/
			//������Ʈ�� ���
			//createPieChart(����,�����ͼ�,����,����,url)
			chart=ChartFactory.createPieChart(
					title, dataset, true, true, false);
			
			//���� ��Ʈ
/*			chart=ChartFactory.createLineChart(title, "��ǰ��", 
					"�ݾ�", dataset, PlotOrientation.VERTICAL,
					true,true,false);*/
			
			//import java.awt.Font
			//��Ʈ ���� ��Ʈ
			chart.getTitle().setFont(new Font("����",Font.BOLD,15));
			//���� ��Ʈ
			chart.getLegend().setItemFont(
					new Font("����",Font.PLAIN,10));
			Font font=new Font("����",Font.PLAIN, 12);
			Color color=new Color(0,0,0); //R.G.B black
			StandardChartTheme chartTheme=
				(StandardChartTheme)StandardChartTheme.createJFreeTheme();
			chartTheme.setExtraLargeFont(font);
			chartTheme.setLargeFont(font);
			chartTheme.setRegularFont(font);
			chartTheme.setSmallFont(font);
			
			chartTheme.setAxisLabelPaint(color);//x,y�� ���ڶ�
			chartTheme.setLegendItemPaint(color);
			chartTheme.setItemLabelPaint(color);
			//��Ʈ,�÷��� ��Ʈ�� ����
			chartTheme.apply(chart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chart;
	}

}
