package com.example.car.service.pdf;

import java.io.FileOutputStream;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.car.model.shop.dto.CartDTO;
import com.example.car.service.shop.CartService;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfServiceImpl implements PdfService {
	
	@Inject
	CartService cartService;
	

	@Override
	public String createPdf() {
		String result="";
		try {
			//pdf ���� ��ü
			Document document=new Document();
			//pdf ���� ��ü
			PdfWriter writer=PdfWriter.getInstance(
					document, new FileOutputStream("d:/sample.pdf"));
			document.open();
			//�ѱ��� �����Ǵ� ��Ʈ ����
			BaseFont baseFont=BaseFont.createFont(
					"c:/windows/fonts/malgun.ttf", 
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			//��Ʈ ������ ����
			Font font=new Font(baseFont, 12);
			//4�÷� ���̺�
			PdfPTable table=new PdfPTable(4);
			//Chunk : ����(���� p�±׿� ���), �ؽ�Ʈ ����
			Chunk chunk=new Chunk("��ٱ���",font);
			Paragraph ph=new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);//��� ����
			document.add(ph);
			document.add(Chunk.NEWLINE); //�ٹٲ�
			document.add(Chunk.NEWLINE);
			//PdfPCell : �� ���� ( <td> )
			PdfPCell cell1=new PdfPCell(new Phrase("��ǰ��",font));
			PdfPCell cell2=new PdfPCell(new Phrase("�ܰ�",font));
			PdfPCell cell3=new PdfPCell(new Phrase("����",font));
			PdfPCell cell4=new PdfPCell(new Phrase("�ݾ�",font));
			//��� ����
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			//���̺� �� �߰�
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			
			//��ٱ��� ��� ����, listCart("�����id")
			List<CartDTO> items=cartService.listCart("park");
			for(int i=0; i<items.size(); i++) {
				CartDTO dto=items.get(i);//i��° ���ڵ带 dto�� ����
				PdfPCell cellProductName=new PdfPCell(
						new Phrase(dto.getProduct_name(),font));
				cellProductName.setHorizontalAlignment(
						Element.ALIGN_CENTER);
				table.addCell(cellProductName);//���̺� �� �߰�
				PdfPCell cellPrice=new PdfPCell(
					new Phrase(Integer.toString(dto.getPrice())
							, font));
				cellPrice.setHorizontalAlignment(
						Element.ALIGN_RIGHT);
				table.addCell(cellPrice);
				
				PdfPCell cellAmount=new PdfPCell(
						new Phrase(dto.getAmount()+"", font));
				cellAmount.setHorizontalAlignment(
						Element.ALIGN_RIGHT);
				table.addCell(cellAmount);
				
				PdfPCell cellMoney=new PdfPCell(
						new Phrase(dto.getMoney()+"", font));
				cellMoney.setHorizontalAlignment(
						Element.ALIGN_RIGHT);
				table.addCell(cellMoney);
			}
			
			//document�� ���̺� �߰�
			document.add(table);
			//close() �Ҷ� pdf ������ ������
			document.close();
			
			result="pdf ������ �����Ǿ����ϴ�.";
		} catch (Exception e) {
			result="pdf ���� ���� ����...";
			e.printStackTrace();
		}
		return result;
	}

}
