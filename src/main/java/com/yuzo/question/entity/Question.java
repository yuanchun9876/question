package com.yuzo.question.entity;

import java.util.Date;

public class Question {
    private String qstnId;

    private String subjSctnId;

    private String qstnTypeId;

    private String qstnFromTypeId;

    private String qstnTitle;

    private Date qstnInputTime;

    private String qstnPictext;

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
}