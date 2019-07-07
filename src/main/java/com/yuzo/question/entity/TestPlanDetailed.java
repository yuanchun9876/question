package com.yuzo.question.entity;

public class TestPlanDetailed {
    private String tpDtdId;

    private String tpId;

    private String subjUnitId;

    private String subjSctnId;

    private String subjId;

    private String qstnTypeId;

    private String qstnFromTypeId;

    private Integer fromNum;

    private Integer typeNum;

    private Integer subjNum;

    private Integer unitNum;

    private Integer sctnNum;

    private String tpDtdType; //1.类型 2.来源 3.科目 4.章 5.节

    public String getTpDtdId() {
        return tpDtdId;
    }

    public void setTpDtdId(String tpDtdId) {
        this.tpDtdId = tpDtdId == null ? null : tpDtdId.trim();
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId == null ? null : tpId.trim();
    }

    public String getSubjUnitId() {
        return subjUnitId;
    }

    public void setSubjUnitId(String subjUnitId) {
        this.subjUnitId = subjUnitId == null ? null : subjUnitId.trim();
    }

    public String getSubjSctnId() {
        return subjSctnId;
    }

    public void setSubjSctnId(String subjSctnId) {
        this.subjSctnId = subjSctnId == null ? null : subjSctnId.trim();
    }

    public String getSubjId() {
        return subjId;
    }

    public void setSubjId(String subjId) {
        this.subjId = subjId == null ? null : subjId.trim();
    }

    public String getQstnTypeId() {
        return qstnTypeId;
    }

    public void setQstnTypeId(String qstnTypeId) {
        this.qstnTypeId = qstnTypeId == null ? null : qstnTypeId.trim();
    }

    public String getQstnFromTypeId() {
        return qstnFromTypeId;
    }

    public void setQstnFromTypeId(String qstnFromTypeId) {
        this.qstnFromTypeId = qstnFromTypeId == null ? null : qstnFromTypeId.trim();
    }

    public Integer getFromNum() {
        return fromNum;
    }

    public void setFromNum(Integer fromNum) {
        this.fromNum = fromNum;
    }

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }

    public Integer getSubjNum() {
        return subjNum;
    }

    public void setSubjNum(Integer subjNum) {
        this.subjNum = subjNum;
    }

    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
    }

    public Integer getSctnNum() {
        return sctnNum;
    }

    public void setSctnNum(Integer sctnNum) {
        this.sctnNum = sctnNum;
    }

    public String getTpDtdType() {
        return tpDtdType;
    }

    public void setTpDtdType(String tpDtdType) {
        this.tpDtdType = tpDtdType == null ? null : tpDtdType.trim();
    }
}