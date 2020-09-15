package com.alex0517.BoardDto;

public class InvestmentDto_1 {
	//변수
	private int no;
	private String name;
	//getter setter
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	//생성자
	public InvestmentDto_1() {	}
	public InvestmentDto_1(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	//toString
	@Override
	public String toString() {
		return "InvestmentDto_1 [no=" + no + ", name=" + name + "]";
	}
	
	
}//end class
