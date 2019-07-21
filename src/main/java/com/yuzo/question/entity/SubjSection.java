package com.yuzo.question.entity;

public class SubjSection {
	
    private String subjSctnId;

    private String subjUnitId;

    private String subjSctnTitle;

    private Integer subjSctnNum;

    private String subjSctnCode;

    private String subjSctnInfo;

    private String subjSctnLogoUrl;

    private String subjSctnVideoUrl;

    private String subjSctnPicText;

    private Integer subjSctnVideoLen;
    
    private Integer sctnCount;
    
    private String subjUnitTitle;
    
    

    public Integer getSctnCount() {
		return sctnCount;
	}

	public void setSctnCount(Integer sctnCount) {
		this.sctnCount = sctnCount;
	}

	public String getSubjSctnId() {
        return subjSctnId;
    }

    public void setSubjSctnId(String subjSctnId) {
        this.subjSctnId = subjSctnId == null ? null : subjSctnId.trim();
    }

    public String getSubjUnitId() {
        return subjUnitId;
    }

    public void setSubjUnitId(String subjUnitId) {
        this.subjUnitId = subjUnitId == null ? null : subjUnitId.trim();
    }

    public String getSubjSctnTitle() {
        return subjSctnTitle;
    }

    public void setSubjSctnTitle(String subjSctnTitle) {
        this.subjSctnTitle = subjSctnTitle == null ? null : subjSctnTitle.trim();
    }

    public Integer getSubjSctnNum() {
        return subjSctnNum;
    }

    public void setSubjSctnNum(Integer subjSctnNum) {
        this.subjSctnNum = subjSctnNum;
    }

    public String getSubjSctnCode() {
        return subjSctnCode;
    }

    public void setSubjSctnCode(String subjSctnCode) {
        this.subjSctnCode = subjSctnCode == null ? null : subjSctnCode.trim();
    }

    public String getSubjSctnInfo() {
        return subjSctnInfo;
    }

    public void setSubjSctnInfo(String subjSctnInfo) {
        this.subjSctnInfo = subjSctnInfo == null ? null : subjSctnInfo.trim();
    }

    public String getSubjSctnLogoUrl() {
        return subjSctnLogoUrl;
    }

    public void setSubjSctnLogoUrl(String subjSctnLogoUrl) {
        this.subjSctnLogoUrl = subjSctnLogoUrl == null ? null : subjSctnLogoUrl.trim();
    }

    public String getSubjSctnVideoUrl() {
        return subjSctnVideoUrl;
    }

    public void setSubjSctnVideoUrl(String subjSctnVideoUrl) {
        this.subjSctnVideoUrl = subjSctnVideoUrl == null ? null : subjSctnVideoUrl.trim();
    }

    public String getSubjSctnPicText() {
        return subjSctnPicText;
    }

    public void setSubjSctnPicText(String subjSctnPicText) {
        this.subjSctnPicText = subjSctnPicText == null ? null : subjSctnPicText.trim();
    }

    public Integer getSubjSctnVideoLen() {
        return subjSctnVideoLen;
    }

    public void setSubjSctnVideoLen(Integer subjSctnVideoLen) {
        this.subjSctnVideoLen = subjSctnVideoLen;
    }

	public String getSubjUnitTitle() {
		return subjUnitTitle;
	}

	public void setSubjUnitTitle(String subjUnitTitle) {
		this.subjUnitTitle = subjUnitTitle;
	}
    
    
}