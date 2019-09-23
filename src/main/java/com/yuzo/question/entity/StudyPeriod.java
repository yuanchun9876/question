package com.yuzo.question.entity;

public class StudyPeriod {
    private String pdId;

    private String pdName;

    private String pdInfo;

    private String pdCode;

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId == null ? null : pdId.trim();
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName == null ? null : pdName.trim();
    }

    public String getPdInfo() {
        return pdInfo;
    }

    public void setPdInfo(String pdInfo) {
        this.pdInfo = pdInfo == null ? null : pdInfo.trim();
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode == null ? null : pdCode.trim();
    }
}