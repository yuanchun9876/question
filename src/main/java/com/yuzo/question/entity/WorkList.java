package com.yuzo.question.entity;

public class WorkList {
    private String wlId;

    private String wtId;

    private String wlTitle;

    private String wlInfo;

    private Integer wlNum;
    
    private String wtName;
    
    private String wtCode;
       
    private String crseId;

    private String crseName;
    
    

	@Override
	public String toString() {
		return "WorkList [wlId=" + wlId + ", wtId=" + wtId + ", wlTitle=" + wlTitle + ", wlInfo=" + wlInfo + ", wlNum="
				+ wlNum + ", wtName=" + wtName + ", wtCode=" + wtCode + ", crseId=" + crseId + ", crseName=" + crseName
				+ "]";
	}

	public String getWlId() {
        return wlId;
    }

    public void setWlId(String wlId) {
        this.wlId = wlId == null ? null : wlId.trim();
    }

    public String getWtId() {
        return wtId;
    }

    public void setWtId(String wtId) {
        this.wtId = wtId == null ? null : wtId.trim();
    }

    public String getWlTitle() {
        return wlTitle;
    }

    public void setWlTitle(String wlTitle) {
        this.wlTitle = wlTitle == null ? null : wlTitle.trim();
    }

    public String getWlInfo() {
        return wlInfo;
    }

    public void setWlInfo(String wlInfo) {
        this.wlInfo = wlInfo == null ? null : wlInfo.trim();
    }

    public Integer getWlNum() {
        return wlNum;
    }

    public void setWlNum(Integer wlNum) {
        this.wlNum = wlNum;
    }

	public String getWtName() {
		return wtName;
	}

	public void setWtName(String wtName) {
		this.wtName = wtName;
	}

	public String getWtCode() {
		return wtCode;
	}

	public void setWtCode(String wtCode) {
		this.wtCode = wtCode;
	}

	public String getCrseId() {
		return crseId;
	}

	public void setCrseId(String crseId) {
		this.crseId = crseId;
	}

	public String getCrseName() {
		return crseName;
	}

	public void setCrseName(String crseName) {
		this.crseName = crseName;
	}
    
    
}