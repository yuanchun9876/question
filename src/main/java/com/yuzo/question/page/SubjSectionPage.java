package com.yuzo.question.page;

public class SubjSectionPage {
	
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	
	
	
	
	@Override
	public String toString() {
		return "SubjSectionPage [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
