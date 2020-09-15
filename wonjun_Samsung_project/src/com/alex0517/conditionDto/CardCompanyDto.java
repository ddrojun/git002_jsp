package com.alex0517.conditionDto;

public class CardCompanyDto {
	//변수
	private String idnum;
	private String company;
	private String ip;
	private String writer;
	//getter setter
	public String getIdnum() { return idnum; }
	public void setIdnum(String idnum) { this.idnum = idnum; }
	public String getCompany() { return company; }
	public void setCompany(String compnay) { this.company = compnay; }
	public String getIp() { return ip; }
	public void setIp(String ip) { this.ip = ip; }
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
	//생성자
	public CardCompanyDto() {}
	public CardCompanyDto(String idnum, String company, String ip, String writer) {
		super();
		this.idnum = idnum;
		this.company = company;
		this.ip = ip;
		this.writer = writer;
	}
	//toString
	@Override
	public String toString() {
		return "CardCompanyDto [idnum=" + idnum + ", company=" + company + ", ip=" + ip + ", writer=" + writer + "]";
	}
	
	
	
}//end class
