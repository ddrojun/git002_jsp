package com.alex0517.BoardDto;

public class BoardDto_1 { //카드정보
	//변수
	private int cno;
	private String cname;
	private String cdate;
	private String crate;
	private String cinfo;
	//getter setter
	public int getCno() { return cno; }
	public void setCno(int cno) { this.cno = cno; }
	public String getCname() { return cname; }
	public void setCname(String cname) { this.cname = cname; }
	public String getCdate() { return cdate; }
	public void setCdate(String cdate) { this.cdate = cdate; }
	public String getCrate() { return crate; }
	public void setCrate(String crate) { this.crate = crate; }
	public String getCinfo() { return cinfo; }
	public void setCinfo(String cinfo) { this.cinfo = cinfo; }
	//생성자
	public BoardDto_1() {	}
	public BoardDto_1(int cno, String cname, String cdate, String crate, String cinfo) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cdate = cdate;
		this.crate = crate;
		this.cinfo = cinfo;
	}
	//toString
	@Override
	public String toString() {
		return "BoardDto [cno=" + cno + ", cname=" + cname + ", cdate=" + cdate + ", crate=" + crate + ", cinfo="
				+ cinfo + "]";
	}
	
	
}//end class
