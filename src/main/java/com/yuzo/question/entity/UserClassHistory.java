package com.yuzo.question.entity;

public class UserClassHistory {
    private String ucId;

    private String userId;

    private String mcId;

    private Integer ucPoints;

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
}