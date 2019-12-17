package com.example.car.model.member2.dto;

import java.util.Date;

public class Member2DTO {
	
	private String userid;
	private String passwd; 
	private String name; 
	private String email; 
	private String addr1;//주소 추가
	private String addr2;//주소 추가
	private String addr3;//주소 추가
	private Date join_date; //java.util.Date
	
	//getter,setter,toString(),기본생성자
	
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "Member2DTO [userid=" + userid + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", addr1="
				+ addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + ", join_date=" + join_date + "]";
	}
	public Member2DTO() {

	}

}
