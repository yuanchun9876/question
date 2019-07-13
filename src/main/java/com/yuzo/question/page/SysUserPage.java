package com.yuzo.question.page;

public class SysUserPage {
	
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	
	private String	tmId;
	
	
	


	@Override
	public String toString() {
		return "UserTeamPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", tmId=" + tmId + "]";
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
	public String getTmId() {
		return tmId;
	}
	public void setTmId(String tmId) {
		this.tmId = tmId;
	}


	

}
