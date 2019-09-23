package com.yuzo.question.entity;

public class StudyCourse {
    private String crseId;

    private String pdId;

    private String crseName;

    private String crseInfo;

    private String crseNum;
    
    
    private String pdName;
    
    



	@Override
	public String toString() {
		return "StudyCourse [crseId=" + crseId + ", pdId=" + pdId + ", crseName=" + crseName + ", crseInfo=" + crseInfo
				+ ", crseNum=" + crseNum + ", pdName=" + pdName + "]";
	}

	public String getCrseId() {
        return crseId;
    }

    public void setCrseId(String crseId) {
        this.crseId = crseId == null ? null : crseId.trim();
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId == null ? null : pdId.trim();
    }

    public String getCrseName() {
        return crseName;
    }

    public void setCrseName(String crseName) {
        this.crseName = crseName == null ? null : crseName.trim();
    }

    public String getCrseInfo() {
        return crseInfo;
    }

    public void setCrseInfo(String crseInfo) {
        this.crseInfo = crseInfo == null ? null : crseInfo.trim();
    }

    public String getCrseNum() {
        return crseNum;
    }

    public void setCrseNum(String crseNum) {
        this.crseNum = crseNum == null ? null : crseNum.trim();
    }

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
    
    
}