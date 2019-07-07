package com.yuzo.question.entity;

public class TestPater {
    private String tpPtId;

    private String tpId;

    private String qstnId;

    public String getTpPtId() {
        return tpPtId;
    }

    public void setTpPtId(String tpPtId) {
        this.tpPtId = tpPtId == null ? null : tpPtId.trim();
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId == null ? null : tpId.trim();
    }

    public String getQstnId() {
        return qstnId;
    }

    public void setQstnId(String qstnId) {
        this.qstnId = qstnId == null ? null : qstnId.trim();
    }
}