package com.yuzo.question.entity;

public class Answer {
    private String ansId;

    private String qstnId;

    private String ansContent;

    private String ansIsright;
    
    private Integer ansNum;
    

    
    
    @Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", qstnId=" + qstnId + ", ansContent=" + ansContent + ", ansIsright="
				+ ansIsright + ", ansNum=" + ansNum + "]";
	}

	public String getAnsId() {
        return ansId;
    }

    public void setAnsId(String ansId) {
        this.ansId = ansId == null ? null : ansId.trim();
    }

    public String getQstnId() {
        return qstnId;
    }

    public void setQstnId(String qstnId) {
        this.qstnId = qstnId == null ? null : qstnId.trim();
    }

    public String getAnsContent() {
        return ansContent;
    }

    public void setAnsContent(String ansContent) {
        this.ansContent = ansContent == null ? null : ansContent.trim();
    }

    public String getAnsIsright() {
        return ansIsright;
    }

    public void setAnsIsright(String ansIsright) {
        this.ansIsright = ansIsright == null ? null : ansIsright.trim();
    }

	public Integer getAnsNum() {
		return ansNum;
	}

	public void setAnsNum(Integer ansNum) {
		this.ansNum = ansNum;
	}
    
    
}