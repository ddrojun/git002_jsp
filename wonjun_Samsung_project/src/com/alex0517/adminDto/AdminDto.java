package com.alex0517.adminDto;

public class AdminDto {
	//변수
	private int ano;
	private String aid;
	private String apass;
	private String aip;
	//getter setter
	public int getAno() { return ano; }
	public void setAno(int ano) { this.ano = ano; }
	public String getAid() { return aid; }
	public void setAid(String aid) { this.aid = aid; }
	public String getApass() { return apass; }
	public void setApass(String apass) { this.apass = apass; }
	public String getAip() { return aip; }
	public void setAip(String aip) { this.aip = aip; }
	//생성자
	public AdminDto() {	}
	public AdminDto(int ano, String aid, String apass, String aip) {
		super();
		this.ano = ano;
		this.aid = aid;
		this.apass = apass;
		this.aip = aip;
	}
	//toString
	@Override
	public String toString() {
		return "AdminDto [ano=" + ano + ", aid=" + aid + ", apass=" + apass + ", aip=" + aip + "]";
	}
	
	
}//end class
