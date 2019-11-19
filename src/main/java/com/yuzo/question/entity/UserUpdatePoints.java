package com.yuzo.question.entity;

import java.util.Date;

public class UserUpdatePoints {
    private String uupId;

    private String uuptId;

    private String userId;

    private Date uupTime;

    private String uupInfo;
    
    private String uuptInfo;
    
    private Integer uuptPrimaryPoint;
    
    private String wlId;
    
    private String wlTitle;
    
    private String wtCode;
    
    private String relationUupId;
    
    
    
    
    

    @Override
	public String toString() {
		return "UserUpdatePoints [uupId=" + uupId + ", uuptId=" + uuptId + ", userId=" + userId + ", uupTime=" + uupTime
				+ ", uupInfo=" + uupInfo + ", uuptInfo=" + uuptInfo + ", uuptPrimaryPoint=" + uuptPrimaryPoint
				+ ", wlId=" + wlId + ", wlTitle=" + wlTitle + ", wtCode=" + wtCode + ", relationUupId=" + relationUupId
				+ "]";
	}

	public String getRelationUupId() {
		return relationUupId;
	}

	public void setRelationUupId(String relationUupId) {
		this.relationUupId = relationUupId;
	}

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

	public String getWlId() {
		return wlId;
	}

	public void setWlId(String wlId) {
		this.wlId = wlId;
	}

	public String getWlTitle() {
		return wlTitle;
	}

	public void setWlTitle(String wlTitle) {
		this.wlTitle = wlTitle;
	}

	public String getWtCode() {
		return wtCode;
	}

	public void setWtCode(String wtCode) {
		this.wtCode = wtCode;
	}

	public Integer getUuptPrimaryPoint() {
		return uuptPrimaryPoint;
	}

	public void setUuptPrimaryPoint(Integer uuptPrimaryPoint) {
		this.uuptPrimaryPoint = uuptPrimaryPoint;
	}
    
    
}