package com.tj.java1129board;

public class Member {
	private String memberid;
	private String memberpw;
	private String membername;
	private String membertel;
	private String memberemail;
	private String membernickname;
	private String memberimage;
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMembertel() {
		return membertel;
	}
	public void setMembertel(String membertel) {
		this.membertel = membertel;
	}
	public String getMemberemail() {
		return memberemail;
	}
	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	public String getMembernickname() {
		return membernickname;
	}
	public void setMembernickname(String membernickname) {
		this.membernickname = membernickname;
	}
	public String getMemberimage() {
		return memberimage;
	}
	public void setMemberimage(String memberimage) {
		this.memberimage = memberimage;
	}
	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", memberpw=" + memberpw + ", membername=" + membername + ", membertel="
				+ membertel + ", memberemail=" + memberemail + ", membernickname=" + membernickname + ", memberimage="
				+ memberimage + "]";
	}

}
