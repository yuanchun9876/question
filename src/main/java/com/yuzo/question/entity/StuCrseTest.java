package com.yuzo.question.entity;

import java.util.Date;

public class StuCrseTest {
    private String sctId;

    private String userId;

    private Date sctTime;

    private String crseId;

    private Integer sctTotal;

    private Integer sctNum;

    private Integer sctLen;
    
    private String crseName;
    
    
    
    

    @Override
	public String toString() {
		return "StuCrseTest [sctId=" + sctId + ", userId=" + userId + ", sctTime=" + sctTime + ", crseId=" + crseId
				+ ", sctTotal=" + sctTotal + ", sctNum=" + sctNum + ", sctLen=" + sctLen + ", crseName=" + crseName
				+ "]";
	}

	public String getSctId() {
        return sctId;
    }

    public void setSctId(String sctId) {
        this.sctId = sctId == null ? null : sctId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getSctTime() {
        return sctTime;
    }

    public void setSctTime(Date sctTime) {
        this.sctTime = sctTime;
    }

    public String getCrseId() {
        return crseId;
    }

    public void setCrseId(String crseId) {
        this.crseId = crseId == null ? null : crseId.trim();
    }

    public Integer getSctTotal() {
        return sctTotal;
    }

    public void setSctTotal(Integer sctTotal) {
        this.sctTotal = sctTotal;
    }

    public Integer getSctNum() {
        return sctNum;
    }

    public void setSctNum(Integer sctNum) {
        this.sctNum = sctNum;
    }

    public Integer getSctLen() {
        return sctLen;
    }
    public String getSctTimeLen() {
    	String time = "";
    	if(this.sctLen !=null  &&  this.sctLen >= 0) {
    		time = this.sctLen/60 + " : " + this.sctLen%60;
    	}  	
    	return time;
    }

    public void setSctLen(Integer sctLen) {
        this.sctLen = sctLen;
    }

	public String getCrseName() {
		return crseName;
	}

	public void setCrseName(String crseName) {
		this.crseName = crseName;
	}
    
}