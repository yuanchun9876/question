package com.yuzo.question.entity;

import java.util.Date;

public class QuestionFeedback {
    private String qtfbId;

    private String qstnId;

    private String userId;

    private String qtfbInfo;

    private Date qtfbTime;

    private String qtfbState;
    
    
    private String qstnCode;
    private String nickName;
    
    private String qstnTypeId;
    



	@Override
	public String toString() {
		return "QuestionFeedback [qtfbId=" + qtfbId + ", qstnId=" + qstnId + ", userId=" + userId + ", qtfbInfo="
				+ qtfbInfo + ", qtfbTime=" + qtfbTime + ", qtfbState=" + qtfbState + ", qstnCode=" + qstnCode
				+ ", nickName=" + nickName + "]";
	}

	public String getQstnCode() {
		return qstnCode;
	}

	public void setQstnCode(String qstnCode) {
		this.qstnCode = qstnCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getQtfbId() {
        return qtfbId;
    }

    public void setQtfbId(String qtfbId) {
        this.qtfbId = qtfbId == null ? null : qtfbId.trim();
    }

    public String getQstnId() {
        return qstnId;
    }

    public void setQstnId(String qstnId) {
        this.qstnId = qstnId == null ? null : qstnId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getQtfbInfo() {
        return qtfbInfo;
    }

    public void setQtfbInfo(String qtfbInfo) {
        this.qtfbInfo = qtfbInfo == null ? null : qtfbInfo.trim();
    }

    public Date getQtfbTime() {
        return qtfbTime;
    }

    public void setQtfbTime(Date qtfbTime) {
        this.qtfbTime = qtfbTime;
    }

    public String getQtfbState() {
        return qtfbState;
    }

    public void setQtfbState(String qtfbState) {
        this.qtfbState = qtfbState == null ? null : qtfbState.trim();
    }

	public String getQstnTypeId() {
		return qstnTypeId;
	}

	public void setQstnTypeId(String qstnTypeId) {
		this.qstnTypeId = qstnTypeId;
	}
    
    
}