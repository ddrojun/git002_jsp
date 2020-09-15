package com.alex0517.conditionDto;

public class CardBenefitDto {
	//변수
	private int cbno;
	private int no;
	private String oil;
	private String moive;
	private String coffee;
	private String transportation;
	private String air;
	private String shopping;
	private String fastfood;
	private String phone;
	private String mart;
	private String date;
	private String ip;
	private String writer;
	//getter setter
	public int getCbno() { return cbno; }
	public void setCbno(int cbno) { this.cbno = cbno; }
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getOil() { return oil; }
	public void setOil(String oil) { this.oil = oil; }
	public String getMoive() { return moive; }
	public void setMoive(String moive) { this.moive = moive; }
	public String getCoffee() { return coffee; }
	public void setCoffee(String coffee) { this.coffee = coffee; }
	public String getTransportation() { return transportation; }
	public void setTransportation(String transportation) { this.transportation = transportation; }
	public String getAir() { return air; }
	public void setAir(String air) { this.air = air; }
	public String getShopping() { return shopping; }
	public void setShopping(String shopping) { this.shopping = shopping; }
	public String getFastfood() { return fastfood; }
	public void setFastfood(String fastfood) { this.fastfood = fastfood; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getMart() { return mart; }
	public void setMart(String mart) { this.mart = mart; }
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	public String getIp() { return ip; }
	public void setIp(String ip) { this.ip = ip; }
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
	//생성자
	public CardBenefitDto() { super();	}
	public CardBenefitDto(int cbno, int no, String oil, String moive, String coffee, String transportation, String air,
			String shopping, String fastfood, String phone, String mart, String date, String ip, String writer) {
		super();
		this.cbno = cbno;
		this.no = no;
		this.oil = oil;
		this.moive = moive;
		this.coffee = coffee;
		this.transportation = transportation;
		this.air = air;
		this.shopping = shopping;
		this.fastfood = fastfood;
		this.phone = phone;
		this.mart = mart;
		this.date = date;
		this.ip = ip;
		this.writer = writer;
	}
	//toString
	@Override
	public String toString() {
		return "CardBenefitDto [cbno=" + cbno + ", no=" + no + ", oil=" + oil + ", moive=" + moive + ", coffee="
				+ coffee + ", transportation=" + transportation + ", air=" + air + ", shopping=" + shopping
				+ ", fastfood=" + fastfood + ", phone=" + phone + ", mart=" + mart + ", date=" + date + ", ip=" + ip
				+ ", writer=" + writer + "]";
	}
	
}//end class
