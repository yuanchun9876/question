package com.yuzo.question.entity;

// crse_qstn_flag
public class StudyCourseQuestion {
    private String crseQstnId;

    private String crseId;

    private String qstnId;

    private String qstnTypeId;

    private String subjSctnId;
    
    private String qstnCode;
    private String qstnTypeName;
    private String subjSctnTitle;
    
    private String crseQstnFlag;

    public String getCrseQstnId() {
        return crseQstnId;
    }

    public void setCrseQstnId(String crseQstnId) {
        this.crseQstnId = crseQstnId == null ? null : crseQstnId.trim();
    }

    public String getCrseId() {
        return crseId;
    }

    public void setCrseId(String crseId) {
        this.crseId = crseId == null ? null : crseId.trim();
    }

    public String getQstnId() {
        return qstnId;
    }

    public void setQstnId(String qstnId) {
        this.qstnId = qstnId == null ? null : qstnId.trim();
    }

    public String getQstnTypeId() {
        return qstnTypeId;
    }

    public void setQstnTypeId(String qstnTypeId) {
        this.qstnTypeId = qstnTypeId == null ? null : qstnTypeId.trim();
    }

    public String getSubjSctnId() {
        return subjSctnId;
    }

    public void setSubjSctnId(String subjSctnId) {
        this.subjSctnId = subjSctnId == null ? null : subjSctnId.trim();
    }

	public String getQstnCode() {
		return qstnCode;
	}

	public void setQstnCode(String qstnCode) {
		this.qstnCode = qstnCode;
	}

	public String getQstnTypeName() {
		return qstnTypeName;
	}

	public void setQstnTypeName(String qstnTypeName) {
		this.qstnTypeName = qstnTypeName;
	}

	public String getSubjSctnTitle() {
		return subjSctnTitle;
	}

	public void setSubjSctnTitle(String subjSctnTitle) {
		this.subjSctnTitle = subjSctnTitle;
	}

	public String getCrseQstnFlag() {
		return crseQstnFlag;
	}

	public void setCrseQstnFlag(String crseQstnFlag) {
		this.crseQstnFlag = crseQstnFlag;
	}
    
    
}