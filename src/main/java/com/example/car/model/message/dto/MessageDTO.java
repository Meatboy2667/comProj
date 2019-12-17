package com.example.car.model.message.dto;

import java.util.Date;

public class MessageDTO {

	private int mid; //메시지 일련번호
	private String targetid; //수신자 아이디
	private String sender;//발신자아이디
	private String message; //메시지 내용
	private Date opendate;
	private Date      senddate;
	//getter, setter, toString()
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTargetid() {
		return targetid;
	}
	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public Date getSenddate() {
		return senddate;
	}
	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	@Override
	public String toString() {
		return "MessageDTO [mid=" + mid + ", targetid=" + targetid + ", sender=" + sender + ", message=" + message
				+ ", opendate=" + opendate + ", senddate=" + senddate + "]";
	}
	
	
}
