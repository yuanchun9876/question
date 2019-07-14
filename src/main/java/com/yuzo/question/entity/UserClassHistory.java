package com.yuzo.question.entity;

import java.util.Date;

public class UserClassHistory {
    private String ucId;

    private String userId;

    private String mcId;

    private Integer ucPoints;

    private Date ucInDate;

    private String ucState;

    public String getUcId() {
        return ucId;
    }

    public void setUcId(String ucId) {
        this.ucId = ucId == null ? null : ucId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId == null ? null : mcId.trim();
    }

    public Integer getUcPoints() {
        return ucPoints;
    }

    public void setUcPoints(Integer ucPoints) {
        this.ucPoints = ucPoints;
    }

    public Date getUcInDate() {
        return ucInDate;
    }

    public void setUcInDate(Date ucInDate) {
        this.ucInDate = ucInDate;
    }

    public String getUcState() {
        return ucState;
    }

    public void setUcState(String ucState) {
        this.ucState = ucState == null ? null : ucState.trim();
    }
}