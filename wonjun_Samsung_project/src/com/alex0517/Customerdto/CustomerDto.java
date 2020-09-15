package com.alex0517.Customerdto;

public class CustomerDto {
	//변수
	private int cno;
	private String cid;
	private String cname;
	private String cpass;
	private String cemail;
	private String cdate;
	private String cip;
	private String cbirth;
	private String cphone;
	//우편번호 입력
	private String cpostcode;	//우편번호
	private String cpost1;		//주소
	private String cpost2;		//상세주소
	
	
	//
	
	//getter setter
	public int getCno() { return cno; }
	public void setCno(int cno) { this.cno = cno; }
	public String getCid() { return cid; }
	public void setCid(String cid) { this.cid = cid; }
	public String getCname() { return cname; }
	public void setCname(String cname) { this.cname = cname; }
	public String getCpass() { return cpass; }
	public void setCpass(String cpass) { this.cpass = cpass; }
	public String getCemail() { return cemail; }
	public void setCemail(String cemail) { this.cemail = cemail; }
	public String getCdate() { return cdate; }
	public void setCdate(String cdate) { this.cdate = cdate; }
	public String getCip() { return cip; }
	public void setCip(String cip) { this.cip = cip; }
	public String getCbirth() { return cbirth; }
	public void setCbirth(String cbirth) { this.cbirth = cbirth; }
	public String getCphone() { return cphone; }
	public void setCphone(String cphone) { this.cphone = cphone; }	
	//
	public String getCpostcode() { return cpostcode; }	//우편번호
	public void setCpostcode(String cpostcode) { this.cpostcode = cpostcode; }	
	//
	public String getCpost1() { return cpost1; }	//주소
	public void setCpost1(String cpost1) { this.cpost1 = cpost1; }	
	//
	public String getCpost2() { return cpost2; }	//상세주소
	public void setCpost2(String cpost2) { this.cpost2 = cpost2; }		
	//생성자
	public CustomerDto() {	}
	public CustomerDto(int cno, String cid, String cname, String cpass, String cemail, String cdate, String cip,
			String cbirth, String cphone, String cpostcode, String cpost1, String cpost2 ) {
		super();
		this.cno = cno;
		this.cid = cid;
		this.cname = cname;
		this.cpass = cpass;
		this.cemail = cemail;
		this.cdate = cdate;
		this.cip = cip;
		this.cbirth = cbirth;
		this.cphone = cphone;
		//
		this.cpostcode =cpostcode;
		this.cpost1 = cpost1;
		this.cpost2 = cpost2;
		
	}
	//toString
	@Override
	public String toString() {
		return "CustomerDto [cno=" + cno + ", cid=" + cid + ", cname=" + cname + ", cpass=" + cpass + ", cemail="
				+ cemail + ", cdate=" + cdate + ", cip=" + cip + ", cbirth=" + cbirth + ", cphone=" + cphone + ", cpostcode=" + cpostcode 
				+ ", cpost1=" + cpost1 + ", cpost2=" + cpost2 + "]";
	}

	
	
	
}
