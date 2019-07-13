package com.yuzo.question.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserMyclass {
    private String mcId;

    private String mcCode;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date mcBeginDate;

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId == null ? null : mcId.trim();
    }

    public String getMcCode() {
        return mcCode;
    }

    public void setMcCode(String mcCode) {
        this.mcCode = mcCode == null ? null : mcCode.trim();
    }

    public Date getMcBeginDate() {
        return mcBeginDate;
    }

    public void setMcBeginDate(Date mcBeginDate) {
        this.mcBeginDate = mcBeginDate;
    }
}