package com.yuzo.question.entity;

import java.util.Date;

public class Teacher {
    private String tchId;

    private String tchName;

    private String tchInfo;

    private Integer tchSex;

    private Date tchRegTime;

    private String tchPic;

    private String tchUser;

    private String tchPass;

    public String getTchId() {
        return tchId;
    }

    public void setTchId(String tchId) {
        this.tchId = tchId == null ? null : tchId.trim();
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName == null ? null : tchName.trim();
    }

    public String getTchInfo() {
        return tchInfo;
    }

    public void setTchInfo(String tchInfo) {
        this.tchInfo = tchInfo == null ? null : tchInfo.trim();
    }

    public Integer getTchSex() {
        return tchSex;
    }

    public void setTchSex(Integer tchSex) {
        this.tchSex = tchSex;
    }

    public Date getTchRegTime() {
        return tchRegTime;
    }

    public void setTchRegTime(Date tchRegTime) {
        this.tchRegTime = tchRegTime;
    }

    public String getTchPic() {
        return tchPic;
    }

    public void setTchPic(String tchPic) {
        this.tchPic = tchPic == null ? null : tchPic.trim();
    }

    public String getTchUser() {
        return tchUser;
    }

    public void setTchUser(String tchUser) {
        this.tchUser = tchUser == null ? null : tchUser.trim();
    }

    public String getTchPass() {
        return tchPass;
    }

    public void setTchPass(String tchPass) {
        this.tchPass = tchPass == null ? null : tchPass.trim();
    }
}