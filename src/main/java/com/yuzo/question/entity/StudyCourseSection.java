package com.yuzo.question.entity;

public class StudyCourseSection {
    private String crseSctnId;

    private String crseId;

    private String subjSctnId;

    public String getCrseSctnId() {
        return crseSctnId;
    }

    public void setCrseSctnId(String crseSctnId) {
        this.crseSctnId = crseSctnId == null ? null : crseSctnId.trim();
    }

    public String getCrseId() {
        return crseId;
    }

    public void setCrseId(String crseId) {
        this.crseId = crseId == null ? null : crseId.trim();
    }

    public String getSubjSctnId() {
        return subjSctnId;
    }

    public void setSubjSctnId(String subjSctnId) {
        this.subjSctnId = subjSctnId == null ? null : subjSctnId.trim();
    }
}