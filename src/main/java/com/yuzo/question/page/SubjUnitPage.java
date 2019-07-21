package com.yuzo.question.page;

public class SubjUnitPage {
	
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	
	private String	subjId;

	
	

	@Override
	public String toString() {
		return "SubjSectionPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", subjId=" + subjId  + "]";
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
	public String getSubjId() {
		return subjId;
	}
	public void setSubjId(String subjId) {
		this.subjId = subjId;
	}

	

}
