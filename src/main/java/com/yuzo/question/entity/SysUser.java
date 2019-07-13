package com.yuzo.question.entity;

public class SysUser {
    private String userId;

    private String userName;

    private String userPass;

    private String nickName;

    private String userState;

    private String userInfo;

    private Integer userSequ;

    private String salt;

    private String userPhone;

    private String userGuardian;

    private String userGudnPhone;

    private String tmId;
    
    
    private String tmName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    public Integer getUserSequ() {
        return userSequ;
    }

    public void setUserSequ(Integer userSequ) {
        this.userSequ = userSequ;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserGuardian() {
        return userGuardian;
    }

    public void setUserGuardian(String userGuardian) {
        this.userGuardian = userGuardian == null ? null : userGuardian.trim();
    }

    public String getUserGudnPhone() {
        return userGudnPhone;
    }

    public void setUserGudnPhone(String userGudnPhone) {
        this.userGudnPhone = userGudnPhone == null ? null : userGudnPhone.trim();
    }

    public String getTmId() {
        return tmId;
    }

    public void setTmId(String tmId) {
        this.tmId = tmId == null ? null : tmId.trim();
    }

	public String getTmName() {
		return tmName;
	}

	public void setTmName(String tmName) {
		this.tmName = tmName;
	}
    
    
}