package com.alex0517.cardbasketDto;

public class CardbasketDto {
	//변수
	private int no;
	private String id;
	private String cardname;
	//
	private int cardnum;
	//getter setter
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getCardname() { return cardname; }
	public void setCardname(String cardname) { this.cardname = cardname; }
	//
	public int getCardnum() { return cardnum; }
	public void setCardnum(int cardnum) { this.cardnum = cardnum; }
	//생성자
	public CardbasketDto() {	}
	public CardbasketDto(int no, String id, String cardname, int cardnum) {
		super();
		this.no = no;
		this.id = id;
		this.cardname = cardname;
		//
		this.cardnum =cardnum;
	}
	//toString
	@Override
	public String toString() {
		return "CardbasketDto [no=" + no + ", id=" + id + ", cardname=" + cardname + ", cardnum=" + cardnum +"]";
	}
	
	
	
}//end class
