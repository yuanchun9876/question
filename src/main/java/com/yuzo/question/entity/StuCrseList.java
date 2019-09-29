package com.yuzo.question.entity;

import java.util.List;

public class StuCrseList {
    private String sclId;

    private String sctId;

    private String qstnId;

    private String sclContent;

    private String sclResult;
    
    
    private String qstnTitle;
    private String qstnCode;
    private String subjSctnId;
    
    
    private String ansContent;
    
    private List<Answer> ansList;
    
    

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

	public String getQstnTitle() {
		return qstnTitle;
	}

	public void setQstnTitle(String qstnTitle) {
		this.qstnTitle = qstnTitle;
	}

	public String getQstnCode() {
		return qstnCode;
	}

	public void setQstnCode(String qstnCode) {
		this.qstnCode = qstnCode;
	}

	public String getSubjSctnId() {
		return subjSctnId;
	}

	public void setSubjSctnId(String subjSctnId) {
		this.subjSctnId = subjSctnId;
	}

	public List<Answer> getAnsList() {
		return ansList;
	}

	public void setAnsList(List<Answer> ansList) {
		this.ansList = ansList;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}
    
    
}