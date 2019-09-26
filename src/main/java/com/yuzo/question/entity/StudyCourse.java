package com.yuzo.question.entity;

public class StudyCourse {
    private String crseId;

    private String pdId;

    private String crseName;

    private String crseInfo;

    private String crseNum;
    
    
    private String pdName;
    
    
    private Integer qstnCount0;

    private Integer qstnCount1;

    private Integer qstnCount2;

    private Integer qstnCount3;

    private Integer qstnCount4;

    private Integer qstnTest0;

    private Integer qstnTest1;

    private Integer qstnTest2;

    private Integer qstnTest3;

    private Integer qstnTest4;



	@Override
	public String toString() {
		return "StudyCourse [crseId=" + crseId + ", pdId=" + pdId + ", crseName=" + crseName + ", crseInfo=" + crseInfo
				+ ", crseNum=" + crseNum + ", pdName=" + pdName + ", qstnCount0=" + qstnCount0 + ", qstnCount1="
				+ qstnCount1 + ", qstnCount2=" + qstnCount2 + ", qstnCount3=" + qstnCount3 + ", qstnCount4="
				+ qstnCount4 + ", qstnTest0=" + qstnTest0 + ", qstnTest1=" + qstnTest1 + ", qstnTest2=" + qstnTest2
				+ ", qstnTest3=" + qstnTest3 + ", qstnTest4=" + qstnTest4 + "]";
	}

	public String getCrseId() {
        return crseId;
    }

    public void setCrseId(String crseId) {
        this.crseId = crseId == null ? null : crseId.trim();
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId == null ? null : pdId.trim();
    }

    public String getCrseName() {
        return crseName;
    }

    public void setCrseName(String crseName) {
        this.crseName = crseName == null ? null : crseName.trim();
    }

    public String getCrseInfo() {
        return crseInfo;
    }

    public void setCrseInfo(String crseInfo) {
        this.crseInfo = crseInfo == null ? null : crseInfo.trim();
    }

    public String getCrseNum() {
        return crseNum;
    }

    public void setCrseNum(String crseNum) {
        this.crseNum = crseNum == null ? null : crseNum.trim();
    }

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public Integer getQstnCount0() {
		return qstnCount0;
	}

	public void setQstnCount0(Integer qstnCount0) {
		this.qstnCount0 = qstnCount0;
	}

	public Integer getQstnCount1() {
		return qstnCount1;
	}

	public void setQstnCount1(Integer qstnCount1) {
		this.qstnCount1 = qstnCount1;
	}

	public Integer getQstnCount2() {
		return qstnCount2;
	}

	public void setQstnCount2(Integer qstnCount2) {
		this.qstnCount2 = qstnCount2;
	}

	public Integer getQstnCount3() {
		return qstnCount3;
	}

	public void setQstnCount3(Integer qstnCount3) {
		this.qstnCount3 = qstnCount3;
	}

	public Integer getQstnCount4() {
		return qstnCount4;
	}

	public void setQstnCount4(Integer qstnCount4) {
		this.qstnCount4 = qstnCount4;
	}

	public Integer getQstnTest0() {
		return qstnTest0;
	}

	public void setQstnTest0(Integer qstnTest0) {
		this.qstnTest0 = qstnTest0;
	}

	public Integer getQstnTest1() {
		return qstnTest1;
	}

	public void setQstnTest1(Integer qstnTest1) {
		this.qstnTest1 = qstnTest1;
	}

	public Integer getQstnTest2() {
		return qstnTest2;
	}

	public void setQstnTest2(Integer qstnTest2) {
		this.qstnTest2 = qstnTest2;
	}

	public Integer getQstnTest3() {
		return qstnTest3;
	}

	public void setQstnTest3(Integer qstnTest3) {
		this.qstnTest3 = qstnTest3;
	}

	public Integer getQstnTest4() {
		return qstnTest4;
	}

	public void setQstnTest4(Integer qstnTest4) {
		this.qstnTest4 = qstnTest4;
	}
    
    
}