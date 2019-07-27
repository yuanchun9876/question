package com.yuzo.question.entity;

import java.util.Date;
import java.util.List;

public class Question {
    private String qstnId;

    private String subjSctnId;

    private String qstnTypeId;

    private String qstnFromTypeId;

    private String qstnTitle;

    private Date qstnInputTime;

    private String qstnPictext;
    
    private Integer qstnNum;
    
    
    private String subjSctnTitle;

    private String qstnTypeName;

    private String qstnFromTypeCode;
    
    private String subjUnitTitle;
    
    private String subjTitle;
    
    
    
    private Integer qstnCount;
    
    // 答案列表
    private List<Answer>  ansList;
    
    
    
    
    

    @Override
	public String toString() {
		return "Question [qstnId=" + qstnId + ", subjSctnId=" + subjSctnId + ", qstnTypeId=" + qstnTypeId
				+ ", qstnFromTypeId=" + qstnFromTypeId + ", qstnTitle=" + qstnTitle + ", qstnInputTime=" + qstnInputTime
				+ ", qstnPictext=" + qstnPictext + ", qstnNum=" + qstnNum + ", subjSctnTitle=" + subjSctnTitle
				+ ", qstnTypeName=" + qstnTypeName + ", qstnFromTypeCode=" + qstnFromTypeCode + ", subjUnitTitle="
				+ subjUnitTitle + ", subjTitle=" + subjTitle + ", qstnCount=" + qstnCount + ", ansList=" + ansList
				+ "]";
	}

	public List<Answer> getAnsList() {
		return ansList;
	}

	public void setAnsList(List<Answer> ansList) {
		this.ansList = ansList;
	}

	public Integer getQstnCount() {
		return qstnCount;
	}

	public void setQstnCount(Integer qstnCount) {
		this.qstnCount = qstnCount;
	}

	public String getQstnId() {
        return qstnId;
    }

    public void setQstnId(String qstnId) {
        this.qstnId = qstnId == null ? null : qstnId.trim();
    }

    public String getSubjSctnId() {
        return subjSctnId;
    }

    public void setSubjSctnId(String subjSctnId) {
        this.subjSctnId = subjSctnId == null ? null : subjSctnId.trim();
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

    public String getQstnTitle() {
        return qstnTitle;
    }

    public void setQstnTitle(String qstnTitle) {
        this.qstnTitle = qstnTitle == null ? null : qstnTitle.trim();
    }

    public Date getQstnInputTime() {
        return qstnInputTime;
    }

    public void setQstnInputTime(Date qstnInputTime) {
        this.qstnInputTime = qstnInputTime;
    }

    public String getQstnPictext() {
        return qstnPictext;
    }

    public void setQstnPictext(String qstnPictext) {
        this.qstnPictext = qstnPictext == null ? null : qstnPictext.trim();
    }

	public String getSubjSctnTitle() {
		return subjSctnTitle;
	}

	public void setSubjSctnTitle(String subjSctnTitle) {
		this.subjSctnTitle = subjSctnTitle;
	}

	public String getQstnTypeName() {
		return qstnTypeName;
	}

	public void setQstnTypeName(String qstnTypeName) {
		this.qstnTypeName = qstnTypeName;
	}

	public String getQstnFromTypeCode() {
		return qstnFromTypeCode;
	}

	public void setQstnFromTypeCode(String qstnFromTypeCode) {
		this.qstnFromTypeCode = qstnFromTypeCode;
	}

	public String getSubjUnitTitle() {
		return subjUnitTitle;
	}

	public void setSubjUnitTitle(String subjUnitTitle) {
		this.subjUnitTitle = subjUnitTitle;
	}

	public String getSubjTitle() {
		return subjTitle;
	}

	public void setSubjTitle(String subjTitle) {
		this.subjTitle = subjTitle;
	}
    
    public Integer getQstnNum() {
        return qstnNum;
    }

    public void setQstnNum(Integer qstnNum) {
        this.qstnNum = qstnNum;
    }
}