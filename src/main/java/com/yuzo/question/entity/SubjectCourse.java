package com.yuzo.question.entity;

public class SubjectCourse {
    private String subjId;

    private String subjTitle;

    private Integer subjNum;

    private String subjCode;

    private String subjLogoUrl;

    private String subjInfo;

    private Integer subjProgress;
    
    
    private Integer subjCount;
    
    
    
    

    public Integer getSubjCount() {
		return subjCount;
	}

	public void setSubjCount(Integer subjCount) {
		this.subjCount = subjCount;
	}

	public String getSubjId() {
        return subjId;
    }

    public void setSubjId(String subjId) {
        this.subjId = subjId == null ? null : subjId.trim();
    }

    public String getSubjTitle() {
        return subjTitle;
    }

    public void setSubjTitle(String subjTitle) {
        this.subjTitle = subjTitle == null ? null : subjTitle.trim();
    }

    public Integer getSubjNum() {
        return subjNum;
    }

    public void setSubjNum(Integer subjNum) {
        this.subjNum = subjNum;
    }

    public String getSubjCode() {
        return subjCode;
    }

    public void setSubjCode(String subjCode) {
        this.subjCode = subjCode == null ? null : subjCode.trim();
    }

    public String getSubjLogoUrl() {
        return subjLogoUrl;
    }

    public void setSubjLogoUrl(String subjLogoUrl) {
        this.subjLogoUrl = subjLogoUrl == null ? null : subjLogoUrl.trim();
    }

    public String getSubjInfo() {
        return subjInfo;
    }

    public void setSubjInfo(String subjInfo) {
        this.subjInfo = subjInfo == null ? null : subjInfo.trim();
    }

    public Integer getSubjProgress() {
        return subjProgress;
    }

    public void setSubjProgress(Integer subjProgress) {
        this.subjProgress = subjProgress;
    }
}