package com.yuzo.question.page;

public class SysUserPage {
	
	private Integer pageNum = 1;
	private Integer pageSize = 8;
	
	private String	tmId;
	private String	mcId;
	private String userName;
	
	
	


	@Override
	public String toString() {
		return "UserTeamPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", tmId=" + tmId + ", mcId=" + mcId + ", userName=" + userName + "]";
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
	public String getMcId() {
		return mcId;
	}
	public void setMcId(String mcId) {
		this.mcId = mcId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	

}
