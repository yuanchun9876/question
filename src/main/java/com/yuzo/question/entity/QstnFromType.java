package com.yuzo.question.entity;

public class QstnFromType {
    private String qstnFromTypeId;

    private String qstnFromTypeCode;

    private String qstnFromTypeInfo;
    
    private Integer qstnFromCount;
    
    
    

    public Integer getQstnFromCount() {
		return qstnFromCount;
	}

	public void setQstnFromCount(Integer qstnFromCount) {
		this.qstnFromCount = qstnFromCount;
	}

	public String getQstnFromTypeId() {
        return qstnFromTypeId;
    }

    public void setQstnFromTypeId(String qstnFromTypeId) {
        this.qstnFromTypeId = qstnFromTypeId == null ? null : qstnFromTypeId.trim();
    }

    public String getQstnFromTypeCode() {
        return qstnFromTypeCode;
    }

    public void setQstnFromTypeCode(String qstnFromTypeCode) {
        this.qstnFromTypeCode = qstnFromTypeCode == null ? null : qstnFromTypeCode.trim();
    }

    public String getQstnFromTypeInfo() {
        return qstnFromTypeInfo;
    }

    public void setQstnFromTypeInfo(String qstnFromTypeInfo) {
        this.qstnFromTypeInfo = qstnFromTypeInfo == null ? null : qstnFromTypeInfo.trim();
    }
}