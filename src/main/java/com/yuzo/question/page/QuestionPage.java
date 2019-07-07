package com.yuzo.question.page;

public class QuestionPage {

	private Integer pageNum = 1;
	private Integer pageSize = 5;
	
	private String	qstnTypeId;
	private String	qstnFromTypeId;
	private String	subjId;
	private String	unitId;
	private String	subjSctnId;
	
	
	@Override
	public String toString() {
		return "QuestionPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", qstnTypeId=" + qstnTypeId
				+ ", qstnFromTypeId=" + qstnFromTypeId + ", subjId=" + subjId + ", unitId=" + unitId + ", subjSctnId="
				+ subjSctnId + "]";
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


	public String getQstnTypeId() {
		return qstnTypeId;
	}


	public void setQstnTypeId(String qstnTypeId) {
		this.qstnTypeId = qstnTypeId;
	}


	public String getQstnFromTypeId() {
		return qstnFromTypeId;
	}


	public void setQstnFromTypeId(String qstnFromTypeId) {
		this.qstnFromTypeId = qstnFromTypeId;
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


	public String getSubjSctnId() {
		return subjSctnId;
	}


	public void setSubjSctnId(String subjSctnId) {
		this.subjSctnId = subjSctnId;
	}
	
	
	
}
