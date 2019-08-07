package com.mvc.insta.vo;

import java.util.Date;

public class UserVO {
	private String user_id;
	private String user_email;
	private String user_name;
	private String user_pw;
	private String user_check_pw;
	private String user_phone;
	private Date user_rdate;
	private String user_img;
	private String user_key;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_check_pw() {
		return user_check_pw;
	}
	public void setUser_check_pw(String user_check_pw) {
		this.user_check_pw = user_check_pw;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Date getUser_rdate() {
		return user_rdate;
	}
	public void setUser_rdate(Date user_rdate) {
		this.user_rdate = user_rdate;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getUser_key() {
		return user_key;
	}
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_email=" + user_email + ", user_name=" + user_name + ", user_pw="
				+ user_pw + ", user_check_pw=" + user_check_pw + ", user_phone=" + user_phone + ", user_rdate="
				+ user_rdate + ", user_img=" + user_img + ", user_key=" + user_key + "]";
	}
	
	
	
}
