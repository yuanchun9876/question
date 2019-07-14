package com.yuzo.question.entity;

public class UserReplyList {
    private String urId;

    private String qstnId;

    private String userId;

    private Integer urFlag;

    public String getUrId() {
        return urId;
    }

    public void setUrId(String urId) {
        this.urId = urId == null ? null : urId.trim();
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

    public Integer getUrFlag() {
        return urFlag;
    }

    public void setUrFlag(Integer urFlag) {
        this.urFlag = urFlag;
    }
}