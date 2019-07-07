package com.yuzo.question.entity;

import java.util.Date;

public class TestPlan {
    private String tpId;

    private String tpTitle;

    private Date tpBeginDate;

    private Date tpEndDate;

    private Integer tpCount;

    private Integer tpTotal;

    private Date tpDate;

    private String tpInfo;

    private String tpType;

    private String tpTarget;

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId == null ? null : tpId.trim();
    }

    public String getTpTitle() {
        return tpTitle;
    }

    public void setTpTitle(String tpTitle) {
        this.tpTitle = tpTitle == null ? null : tpTitle.trim();
    }

    public Date getTpBeginDate() {
        return tpBeginDate;
    }

    public void setTpBeginDate(Date tpBeginDate) {
        this.tpBeginDate = tpBeginDate;
    }

    public Date getTpEndDate() {
        return tpEndDate;
    }

    public void setTpEndDate(Date tpEndDate) {
        this.tpEndDate = tpEndDate;
    }

    public Integer getTpCount() {
        return tpCount;
    }

    public void setTpCount(Integer tpCount) {
        this.tpCount = tpCount;
    }

    public Integer getTpTotal() {
        return tpTotal;
    }

    public void setTpTotal(Integer tpTotal) {
        this.tpTotal = tpTotal;
    }

    public Date getTpDate() {
        return tpDate;
    }

    public void setTpDate(Date tpDate) {
        this.tpDate = tpDate;
    }

    public String getTpInfo() {
        return tpInfo;
    }

    public void setTpInfo(String tpInfo) {
        this.tpInfo = tpInfo == null ? null : tpInfo.trim();
    }

    public String getTpType() {
        return tpType;
    }

    public void setTpType(String tpType) {
        this.tpType = tpType == null ? null : tpType.trim();
    }

    public String getTpTarget() {
        return tpTarget;
    }

    public void setTpTarget(String tpTarget) {
        this.tpTarget = tpTarget == null ? null : tpTarget.trim();
    }
}