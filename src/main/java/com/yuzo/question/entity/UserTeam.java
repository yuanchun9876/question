package com.yuzo.question.entity;

public class UserTeam {
    private String tmId;

    private String mcId;

    private String tmName;

    private String tmSlogan;

    private Integer tmTotal;
    
    private Integer tmAvg;
    
    private String mcCode;
    
    
    

    @Override
	public String toString() {
		return "UserTeam [tmId=" + tmId + ", mcId=" + mcId + ", tmName=" + tmName + ", tmSlogan=" + tmSlogan
				+ ", tmTotal=" + tmTotal + ", tmAvg=" + tmAvg + ", mcCode=" + mcCode + "]";
	}

	public String getTmId() {
        return tmId;
    }

    public void setTmId(String tmId) {
        this.tmId = tmId == null ? null : tmId.trim();
    }

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId == null ? null : mcId.trim();
    }

    public String getTmName() {
        return tmName;
    }

    public void setTmName(String tmName) {
        this.tmName = tmName == null ? null : tmName.trim();
    }

    public String getTmSlogan() {
        return tmSlogan;
    }

    public void setTmSlogan(String tmSlogan) {
        this.tmSlogan = tmSlogan == null ? null : tmSlogan.trim();
    }

    public Integer getTmTotal() {
        return tmTotal;
    }

    public void setTmTotal(Integer tmTotal) {
        this.tmTotal = tmTotal;
    }

	public Integer getTmAvg() {
		return tmAvg;
	}

	public void setTmAvg(Integer tmAvg) {
		this.tmAvg = tmAvg;
	}

	public String getMcCode() {
		return mcCode;
	}

	public void setMcCode(String mcCode) {
		this.mcCode = mcCode;
	}
    
    
}