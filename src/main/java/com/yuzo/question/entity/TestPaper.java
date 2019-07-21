package com.yuzo.question.entity;

public class TestPaper {
    private String tpPpId;

    private String tpId;

    private String qstnId;

    public String getTpPpId() {
        return tpPpId;
    }

    public void setTpPpId(String tpPpId) {
        this.tpPpId = tpPpId == null ? null : tpPpId.trim();
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