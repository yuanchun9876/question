package com.yuzo.question.page;

public class UserTeamPage {
	
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	
	private String	mcId;
	
	
	


	@Override
	public String toString() {
		return "UserTeamPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", mcId=" + mcId + "]";
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
	public String getMcId() {
		return mcId;
	}
	public void setMcId(String mcId) {
		this.mcId = mcId;
	}

	

}
