package com.yuzo.question.entity;

public class WorkType {
    private String wtId;

    private String wtName;

    private String wtInfo;

    private Integer wtAproint;

    private Integer wtCproint;

    private Integer wtEproint;

    public String getWtId() {
        return wtId;
    }

    public void setWtId(String wtId) {
        this.wtId = wtId == null ? null : wtId.trim();
    }

    public String getWtName() {
        return wtName;
    }

    public void setWtName(String wtName) {
        this.wtName = wtName == null ? null : wtName.trim();
    }

    public String getWtInfo() {
        return wtInfo;
    }

    public void setWtInfo(String wtInfo) {
        this.wtInfo = wtInfo == null ? null : wtInfo.trim();
    }

    public Integer getWtAproint() {
        return wtAproint;
    }

    public void setWtAproint(Integer wtAproint) {
        this.wtAproint = wtAproint;
    }

    public Integer getWtCproint() {
        return wtCproint;
    }

    public void setWtCproint(Integer wtCproint) {
        this.wtCproint = wtCproint;
    }

    public Integer getWtEproint() {
        return wtEproint;
    }

    public void setWtEproint(Integer wtEproint) {
        this.wtEproint = wtEproint;
    }
}