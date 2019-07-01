package com.yuzo.question.entity;

public class ResourceType {
    private String rsrcTypeId;

    private String rsrcTypeName;

    private String rsrcTypeInfo;

    private Integer rsrcTypeNum;

    public String getRsrcTypeId() {
        return rsrcTypeId;
    }

    public void setRsrcTypeId(String rsrcTypeId) {
        this.rsrcTypeId = rsrcTypeId == null ? null : rsrcTypeId.trim();
    }

    public String getRsrcTypeName() {
        return rsrcTypeName;
    }

    public void setRsrcTypeName(String rsrcTypeName) {
        this.rsrcTypeName = rsrcTypeName == null ? null : rsrcTypeName.trim();
    }

    public String getRsrcTypeInfo() {
        return rsrcTypeInfo;
    }

    public void setRsrcTypeInfo(String rsrcTypeInfo) {
        this.rsrcTypeInfo = rsrcTypeInfo == null ? null : rsrcTypeInfo.trim();
    }

    public Integer getRsrcTypeNum() {
        return rsrcTypeNum;
    }

    public void setRsrcTypeNum(Integer rsrcTypeNum) {
        this.rsrcTypeNum = rsrcTypeNum;
    }
}