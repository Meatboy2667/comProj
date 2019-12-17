package com.example.car.model.board2.dto;

import java.util.Date;

public class Reply2DTO {
	private int rno; //��� ��ȣ
	private int bno; //�Խù� ��ȣ
	private String replytext; //��� ����
	private String replyer; //��� �ۼ��� id
	private String name; //��� �ۼ��� �̸�
	private Date regdate; //java.util.Date, �ۼ�����
	private Date updatedate; //��������
	private String secret_reply; //��д�� ����
	private String writer; //member ���̺��� id
	//getter,setter,toString()
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getSecret_reply() {
		return secret_reply;
	}
	public void setSecret_reply(String secret_reply) {
		this.secret_reply = secret_reply;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", replyer=" + replyer + ", name="
				+ name + ", regdate=" + regdate + ", updatedate=" + updatedate + ", secret_reply=" + secret_reply
				+ ", writer=" + writer + "]";
	}

}
