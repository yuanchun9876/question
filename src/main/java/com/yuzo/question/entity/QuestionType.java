package com.yuzo.question.entity;

public class QuestionType {
    private String qstnTypeId;

    private String qstnTypeName;

    private String qstnTypeInfo;

    public String getQstnTypeId() {
        return qstnTypeId;
    }

    public void setQstnTypeId(String qstnTypeId) {
        this.qstnTypeId = qstnTypeId == null ? null : qstnTypeId.trim();
    }

    public String getQstnTypeName() {
        return qstnTypeName;
    }

    public void setQstnTypeName(String qstnTypeName) {
        this.qstnTypeName = qstnTypeName == null ? null : qstnTypeName.trim();
    }

    public String getQstnTypeInfo() {
        return qstnTypeInfo;
    }

    public void setQstnTypeInfo(String qstnTypeInfo) {
        this.qstnTypeInfo = qstnTypeInfo == null ? null : qstnTypeInfo.trim();
    }
}