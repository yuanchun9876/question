package com.yuzo.question.entity;

public class ResourceData {
    private String rsrcId;

    private String subjUnitId;

    private String rsrcTypeId;

    private String rsrcName;

    private String rsrcPath;

    private String rsrcInfo;

    private String rsrcLogoUrl;

    public String getRsrcId() {
        return rsrcId;
    }

    public void setRsrcId(String rsrcId) {
        this.rsrcId = rsrcId == null ? null : rsrcId.trim();
    }

    public String getSubjUnitId() {
        return subjUnitId;
    }

    public void setSubjUnitId(String subjUnitId) {
        this.subjUnitId = subjUnitId == null ? null : subjUnitId.trim();
    }

    public String getRsrcTypeId() {
        return rsrcTypeId;
    }

    public void setRsrcTypeId(String rsrcTypeId) {
        this.rsrcTypeId = rsrcTypeId == null ? null : rsrcTypeId.trim();
    }

    public String getRsrcName() {
        return rsrcName;
    }

    public void setRsrcName(String rsrcName) {
        this.rsrcName = rsrcName == null ? null : rsrcName.trim();
    }

    public String getRsrcPath() {
        return rsrcPath;
    }

    public void setRsrcPath(String rsrcPath) {
        this.rsrcPath = rsrcPath == null ? null : rsrcPath.trim();
    }

    public String getRsrcInfo() {
        return rsrcInfo;
    }

    public void setRsrcInfo(String rsrcInfo) {
        this.rsrcInfo = rsrcInfo == null ? null : rsrcInfo.trim();
    }

    public String getRsrcLogoUrl() {
        return rsrcLogoUrl;
    }

    public void setRsrcLogoUrl(String rsrcLogoUrl) {
        this.rsrcLogoUrl = rsrcLogoUrl == null ? null : rsrcLogoUrl.trim();
    }
}