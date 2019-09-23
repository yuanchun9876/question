package com.yuzo.question.entity;

public class StudyCourseQuestion {
    private String crseQstnId;

    private String crseId;

    private String qstnId;

    private String qstnTypeId;

    private String subjSctnId;

    public String getCrseQstnId() {
        return crseQstnId;
    }

    public void setCrseQstnId(String crseQstnId) {
        this.crseQstnId = crseQstnId == null ? null : crseQstnId.trim();
    }

    public String getCrseId() {
        return crseId;
    }

    public void setCrseId(String crseId) {
        this.crseId = crseId == null ? null : crseId.trim();
    }

    public String getQstnId() {
        return qstnId;
    }

    public void setQstnId(String qstnId) {
        this.qstnId = qstnId == null ? null : qstnId.trim();
    }

    public String getQstnTypeId() {
        return qstnTypeId;
    }

    public void setQstnTypeId(String qstnTypeId) {
        this.qstnTypeId = qstnTypeId == null ? null : qstnTypeId.trim();
    }

    public String getSubjSctnId() {
        return subjSctnId;
    }

    public void setSubjSctnId(String subjSctnId) {
        this.subjSctnId = subjSctnId == null ? null : subjSctnId.trim();
    }
}