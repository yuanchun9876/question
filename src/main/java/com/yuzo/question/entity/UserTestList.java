package com.yuzo.question.entity;

import java.util.Date;

public class UserTestList {
    private String utsId;

    private String tpId;

    private String userId;

    private Date utsTime;

    private Integer utsTotal;

    public String getUtsId() {
        return utsId;
    }

    public void setUtsId(String utsId) {
        this.utsId = utsId == null ? null : utsId.trim();
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId == null ? null : tpId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getUtsTime() {
        return utsTime;
    }

    public void setUtsTime(Date utsTime) {
        this.utsTime = utsTime;
    }

    public Integer getUtsTotal() {
        return utsTotal;
    }

    public void setUtsTotal(Integer utsTotal) {
        this.utsTotal = utsTotal;
    }
}