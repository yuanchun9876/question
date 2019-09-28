package com.yuzo.question.entity;

public class StuLevel {
    private String userId;

    private String userCrseLevel;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserCrseLevel() {
        return userCrseLevel;
    }

    public void setUserCrseLevel(String userCrseLevel) {
        this.userCrseLevel = userCrseLevel == null ? null : userCrseLevel.trim();
    }
}