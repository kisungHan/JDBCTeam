package com.kh.team.model.vo;

import java.sql.Date;

public class Member {

	private String memberId;
	private String memberPwd;
	private String memberName;
	private char gender;
	private String memTel;
	private String memAddr;
	private int memGrade;
	private char yn;
	private int rentalCo;
	private int rentalbk;
	private Date enrollDate;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String memberPwd, String memberName, char gender, String memTel, String memAddr,
			int memGrade, char yn, int rentalCo, int rentalbk, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.memTel = memTel;
		this.memAddr = memAddr;
		this.memGrade = memGrade;
		this.yn = yn;
		this.rentalCo = rentalCo;
		this.rentalbk = rentalbk;
		this.enrollDate = enrollDate;
	}
	
	
	

	public Member(String memberId, String memberPwd, String memberName, char gender, String memTel, String memAddr) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.memTel = memTel;
		this.memAddr = memAddr;
	}

	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}

	// getter/setter
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public int getMemGrade() {
		return memGrade;
	}

	public void setMemGrade(int memGrade) {
		this.memGrade = memGrade;
	}

	public char getYn() {
		return yn;
	}

	public void setYn(char yn) {
		this.yn = yn;
	}

	public int getRentalCo() {
		return rentalCo;
	}

	public void setRentalCo(int rentalCo) {
		this.rentalCo = rentalCo;
	}

	public int getRentalbk() {
		return rentalbk;
	}

	public void setRentalbk(int rentalbk) {
		this.rentalbk = rentalbk;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	////////////////
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + ", gender="
				+ gender + ", memTel=" + memTel + ", memAddr=" + memAddr + ", memGrade=" + memGrade + ", yn=" + yn
				+ ", rentalCo=" + rentalCo + ", rentalbk=" + rentalbk + ", enrollDate=" + enrollDate + "]";
	}

}