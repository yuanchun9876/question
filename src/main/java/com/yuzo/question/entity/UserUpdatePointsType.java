package com.yuzo.question.entity;

public class UserUpdatePointsType {
    private String uuptId;

    private String uuptInfo;

    private String uuptType;

    private Integer uuptPrimaryPoint;

    private Integer uuptTeamPoint;

    public String getUuptId() {
        return uuptId;
    }

    public void setUuptId(String uuptId) {
        this.uuptId = uuptId == null ? null : uuptId.trim();
    }

    public String getUuptInfo() {
        return uuptInfo;
    }

    public void setUuptInfo(String uuptInfo) {
        this.uuptInfo = uuptInfo == null ? null : uuptInfo.trim();
    }

    public String getUuptType() {
        return uuptType;
    }

    public void setUuptType(String uuptType) {
        this.uuptType = uuptType == null ? null : uuptType.trim();
    }

    public Integer getUuptPrimaryPoint() {
        return uuptPrimaryPoint;
    }

    public void setUuptPrimaryPoint(Integer uuptPrimaryPoint) {
        this.uuptPrimaryPoint = uuptPrimaryPoint;
    }

    public Integer getUuptTeamPoint() {
        return uuptTeamPoint;
    }

    public void setUuptTeamPoint(Integer uuptTeamPoint) {
        this.uuptTeamPoint = uuptTeamPoint;
    }
}