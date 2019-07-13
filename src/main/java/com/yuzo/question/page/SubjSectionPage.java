package com.yuzo.question.page;

public class SubjSectionPage {
	
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	
	private String	subjId;
	private String	unitId;
	
	

	@Override
	public String toString() {
		return "SubjSectionPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", subjId=" + subjId + ", unitId="
				+ unitId + "]";
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
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	

}
