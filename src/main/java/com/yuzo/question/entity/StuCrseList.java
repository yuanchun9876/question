package com.yuzo.question.entity;

public class StuCrseList {
    private String sclId;

    private String sctId;

    private String qstnId;

    private String sclContent;

    private String sclResult;

    public String getSclId() {
        return sclId;
    }

    public void setSclId(String sclId) {
        this.sclId = sclId == null ? null : sclId.trim();
    }

    public String getSctId() {
        return sctId;
    }

    public void setSctId(String sctId) {
        this.sctId = sctId == null ? null : sctId.trim();
    }

    public String getQstnId() {
        return qstnId;
    }

    public void setQstnId(String qstnId) {
        this.qstnId = qstnId == null ? null : qstnId.trim();
    }

    public String getSclContent() {
        return sclContent;
    }

    public void setSclContent(String sclContent) {
        this.sclContent = sclContent == null ? null : sclContent.trim();
    }

    public String getSclResult() {
        return sclResult;
    }

    public void setSclResult(String sclResult) {
        this.sclResult = sclResult == null ? null : sclResult.trim();
    }
}