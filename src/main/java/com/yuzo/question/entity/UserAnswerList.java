package com.yuzo.question.entity;

import java.util.List;

public class UserAnswerList {
    private String uansId;

    private String utsId;

    private String qstnId;

    private String subjSctnId;

    private String uansContent;

    private String uansResult;
    
    private String qstnTitle;
    
    private List<Answer> ansList;
    
    private String ansContent;
    
    

    @Override
	public String toString() {
		return "UserAnswerList [uansId=" + uansId + ", utsId=" + utsId + ", qstnId=" + qstnId + ", subjSctnId="
				+ subjSctnId + ", uansContent=" + uansContent + ", uansResult=" + uansResult + ", qstnTitle="
				+ qstnTitle + "]";
	}

	public String getUansId() {
        return uansId;
    }

    public void setUansId(String uansId) {
        this.uansId = uansId == null ? null : uansId.trim();
    }

    public String getUtsId() {
        return utsId;
    }

    public void setUtsId(String utsId) {
        this.utsId = utsId == null ? null : utsId.trim();
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

    public String getUansContent() {
        return uansContent;
    }

    public void setUansContent(String uansContent) {
        this.uansContent = uansContent == null ? null : uansContent.trim();
    }

    public String getUansResult() {
        return uansResult;
    }

    public void setUansResult(String uansResult) {
        this.uansResult = uansResult == null ? null : uansResult.trim();
    }

	public String getQstnTitle() {
		return qstnTitle;
	}

	public void setQstnTitle(String qstnTitle) {
		this.qstnTitle = qstnTitle;
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