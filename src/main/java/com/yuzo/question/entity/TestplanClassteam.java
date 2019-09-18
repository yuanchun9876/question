package com.yuzo.question.entity;

public class TestplanClassteam {
    private String tpctId;

    private String tpId;

    private String mcId;

    public String getTpctId() {
        return tpctId;
    }

    public void setTpctId(String tpctId) {
        this.tpctId = tpctId == null ? null : tpctId.trim();
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId == null ? null : tpId.trim();
    }

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId == null ? null : mcId.trim();
    }
}