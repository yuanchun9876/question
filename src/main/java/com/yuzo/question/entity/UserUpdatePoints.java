package com.yuzo.question.entity;

import java.util.Date;

public class UserUpdatePoints {
    private String uupId;

    private String uuptId;

    private String userId;

    private Date uupTime;

    private String uupInfo;
    
    private String uuptInfo;
    
    
    

    public String getUuptInfo() {
		return uuptInfo;
	}

	public void setUuptInfo(String uuptInfo) {
		this.uuptInfo = uuptInfo;
	}

	public String getUupId() {
        return uupId;
    }

    public void setUupId(String uupId) {
        this.uupId = uupId == null ? null : uupId.trim();
    }

    public String getUuptId() {
        return uuptId;
    }

    public void setUuptId(String uuptId) {
        this.uuptId = uuptId == null ? null : uuptId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getUupTime() {
        return uupTime;
    }

    public void setUupTime(Date uupTime) {
        this.uupTime = uupTime;
    }

    public String getUupInfo() {
        return uupInfo;
    }

    public void setUupInfo(String uupInfo) {
        this.uupInfo = uupInfo == null ? null : uupInfo.trim();
    }
}