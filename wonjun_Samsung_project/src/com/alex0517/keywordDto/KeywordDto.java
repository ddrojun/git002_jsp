package com.alex0517.keywordDto;

public class KeywordDto {
	
	//변수
	private int no;
	private String name;
	private String idnum;
	private String gender;	
	private String age;		//전체,20대,30대,40대이상
	private String type1;	//신용/체크
	private String type2;	//전체,할인,포인트
	private int benefit;	
	private String date;
	private String ip;
	private String writer;	//관리자
	//
	private String pic;	//카드사진
	//getter setter
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getIdnum() { return idnum; }
	public void setIdnum(String idnum) { this.idnum = idnum; }
	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }
	public String getAge() { return age; }
	public void setAge(String age) { this.age = age; }
	public String getType1() { return type1; }
	public void setType1(String type1) { this.type1 = type1; }
	public String getType2() { return type2; }
	public void setType2(String type2) { this.type2 = type2; }
	public int getBenefit() { return benefit; }
	public void setBenefit(int benefit) { this.benefit = benefit; }
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	public String getIp() { return ip; }
	public void setIp(String ip) { this.ip = ip; }
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
	
	public String getPic() { return pic; }
	public void setPic(String pic) { this.pic = pic; }
	//toString
	@Override
	public String toString() {
		return "KeywordDto [no=" + no + ", name=" + name + ", idnum=" + idnum + ", gender=" + gender + ", age=" + age
				+ ", type1=" + type1 + ", type2=" + type2 + ", benefit=" + benefit + ", date=" + date + ", ip=" + ip
				+ ", writer=" + writer + ", pic=" + pic + "]";
	}
	//생성자
	public KeywordDto() {	}
	public KeywordDto(int no, String name, String idnum, String gender, String age, String type1, String type2,
			int benefit, String date, String ip, String writer, String pic) {
		super();
		this.no = no;
		this.name = name;
		this.idnum = idnum;
		this.gender = gender;
		this.age = age;
		this.type1 = type1;
		this.type2 = type2;
		this.benefit = benefit;
		this.date = date;
		this.ip = ip;
		this.writer = writer;
		this.pic = pic;
	}
	public KeywordDto(String name, String idnum, String gender, String age, String type1, String type2) {
		super();
		this.name = name;
		this.idnum = idnum;
		this.gender = gender;
		this.age = age;
		this.type1 = type1;
		this.type2 = type2;
	}
	
//			list.add(new KeywordDto(rset.getString("name"),rset.getString("idnum"),
//	rset.getString("gender"),rset.getString("age"),
//	rset.getString("type1"),rset.getString("type2")));	
	
	
	
}//end class
