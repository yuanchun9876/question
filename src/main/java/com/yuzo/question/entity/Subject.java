package com.yuzo.question.entity;

public class Subject {
    private String subjectId;

    private String subjectName;

    private String subjectPid;

    private Integer sorder;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId == null ? null : subjectId.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getSubjectPid() {
        return subjectPid;
    }

    public void setSubjectPid(String subjectPid) {
        this.subjectPid = subjectPid == null ? null : subjectPid.trim();
    }

    public Integer getSorder() {
        return sorder;
    }

    public void setSorder(Integer sorder) {
        this.sorder = sorder;
    }
}