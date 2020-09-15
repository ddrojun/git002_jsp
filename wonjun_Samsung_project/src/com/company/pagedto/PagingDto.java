package com.company.pagedto;

import java.util.ArrayList;

import com.alex0517.BoardDto.BoardDto;

public class PagingDto {
	//변수
	private int pageTotal;		//전체 게시판의 갯수(글의 갯수) 12
	private int onepageLimit;	//한페이지당 보여줄 레코드수(글) 10
	private int pageAll;		//하단 index의 갯수 12/10 : 2
	private int pstartno;		//db에서 가져올 번호(1버튼 0, 2버튼 10)
	private int bottomList;		//하단페이지네비(10)
	private int bottom_current;	//하단페이지네비 - 현재페이지 네비번호
	private int bottom_start;	//하단페이지네비 - 현재페이지기준 - 시작페이지 네비번호
	private int bottom_end;		//하단페이지네비 - 현재페이지기준 - 끝페이지  네비번호
	ArrayList<BoardDto> list;
	///생성자
	public PagingDto() {super();	}
	public PagingDto(int pageTotal, int onepageLimit, int pageAll, int pstartno, int bottomList, int bottom_current,
			int bottom_start, int bottom_end, ArrayList<BoardDto> list) {
		this();
		this.pageTotal = pageTotal;
		this.onepageLimit = onepageLimit;
		this.pageAll = pageAll;
		this.pstartno = pstartno;
		this.bottomList = bottomList;
		this.bottom_current = bottom_current;
		this.bottom_start = bottom_start;
		this.bottom_end = bottom_end;
		this.list = list;
	}
	//getter setter
	public int getPageTotal() { return pageTotal; }
	public void setPageTotal(int pageTotal) { this.pageTotal = pageTotal; }
	public int getOnepageLimit() { return onepageLimit; }
	public void setOnepageLimit(int onepageLimit) { this.onepageLimit = onepageLimit; }
	public int getPageAll() { return pageAll; }
	public void setPageAll(int pageAll) { this.pageAll = pageAll; }
	public int getPstartno() { return pstartno; }
	public void setPstartno(int pstartno) { this.pstartno = pstartno; }
	public int getBottomList() { return bottomList; }
	public void setBottomList(int bottomList) { this.bottomList = bottomList; }
	public int getBottom_current() { return bottom_current; }
	public void setBottom_current(int bottom_current) { this.bottom_current = bottom_current; }
	public int getBottom_start() { return bottom_start; }
	public void setBottom_start(int bottom_start) { this.bottom_start = bottom_start; }
	public int getBottom_end() { return bottom_end; }
	public void setBottom_end(int bottom_end) { this.bottom_end = bottom_end; }
	public ArrayList<BoardDto> getList() { return list; }
	public void setList(ArrayList<BoardDto> list) { this.list = list; }
	//toString
	@Override
	public String toString() {
		return "PagingDto [pageTotal=" + pageTotal + ", onepageLimit=" + onepageLimit + ", pageAll=" + pageAll
				+ ", pstartno=" + pstartno + ", bottomList=" + bottomList + ", bottom_current=" + bottom_current
				+ ", bottom_start=" + bottom_start + ", bottom_end=" + bottom_end + ", list=" + list + "]";
	}
	
	
}//end class
