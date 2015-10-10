package com.ppusari.database.dto;
 
public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	 
	public MemberDto(String id, String pw, String name, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}
 
	public String getId() {
		return id; 
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
