package com.yuzo.question.entity;

public class SubjUnit {
    private String subjUnitId;

    private String subjId;

    private String tchId;

    private String subjUnitTitle;

    private Integer subjUnitNum;

    private String subjUnitCode;

    private String subjUnitInfo;

    private String subjUnitLogoUrl;
    
    private String tchName;

    private String subjTitle;
    
    

    @Override
	public String toString() {
		return "SubjUnit [subjUnitId=" + subjUnitId + ", subjId=" + subjId + ", tchId=" + tchId + ", subjUnitTitle="
				+ subjUnitTitle + ", subjUnitNum=" + subjUnitNum + ", subjUnitCode=" + subjUnitCode + ", subjUnitInfo="
				+ subjUnitInfo + ", subjUnitLogoUrl=" + subjUnitLogoUrl + ", tchName=" + tchName + ", subjTitle="
				+ subjTitle + "]";
	}

	public String getSubjUnitId() {
        return subjUnitId;
    }

    public void setSubjUnitId(String subjUnitId) {
        this.subjUnitId = subjUnitId == null ? null : subjUnitId.trim();
    }

    public String getSubjId() {
        return subjId;
    }

    public void setSubjId(String subjId) {
        this.subjId = subjId == null ? null : subjId.trim();
    }

    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId == null ? null : tchId.trim();
    }

    public String getSubjUnitTitle() {
        return subjUnitTitle;
    }

    public void setSubjUnitTitle(String subjUnitTitle) {
        this.subjUnitTitle = subjUnitTitle == null ? null : subjUnitTitle.trim();
    }

    public Integer getSubjUnitNum() {
        return subjUnitNum;
    }

    public void setSubjUnitNum(Integer subjUnitNum) {
        this.subjUnitNum = subjUnitNum;
    }

    public String getSubjUnitCode() {
        return subjUnitCode;
    }

    public void setSubjUnitCode(String subjUnitCode) {
        this.subjUnitCode = subjUnitCode == null ? null : subjUnitCode.trim();
    }

    public String getSubjUnitInfo() {
        return subjUnitInfo;
    }

    public void setSubjUnitInfo(String subjUnitInfo) {
        this.subjUnitInfo = subjUnitInfo == null ? null : subjUnitInfo.trim();
    }

    public String getSubjUnitLogoUrl() {
        return subjUnitLogoUrl;
    }

    public void setSubjUnitLogoUrl(String subjUnitLogoUrl) {
        this.subjUnitLogoUrl = subjUnitLogoUrl == null ? null : subjUnitLogoUrl.trim();
    }

	public String getTchName() {
		return tchName;
	}

	public void setTchName(String tchName) {
		this.tchName = tchName;
	}

	public String getSubjTitle() {
		return subjTitle;
	}

	public void setSubjTitle(String subjTitle) {
		this.subjTitle = subjTitle;
	}
    
    
}