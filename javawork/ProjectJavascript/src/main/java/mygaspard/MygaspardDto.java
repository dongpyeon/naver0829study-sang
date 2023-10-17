package mygaspard;

import java.sql.Timestamp;

public class MygaspardDto {
	private String num;
	private String gname;
	private String photo;
	private String gender;
	private String phone;
	private String addr;
	private Timestamp registerday;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String name) {
		this.gname = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Timestamp getRegisterday() {
		return registerday;
	}
	public void setRegisterday(Timestamp registerday) {
		this.registerday = registerday;
	}
}
