package com.yuzo.question.entity;

public class StuLevel {
    private String userId;

    private String userCrseLevel;
    
    private String userName;


    private String nickName;
    
    

    @Override
	public String toString() {
		return "StuLevel [userId=" + userId + ", userCrseLevel=" + userCrseLevel + ", userName=" + userName
				+ ", nickName=" + nickName + "]";
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserCrseLevel() {
        return userCrseLevel;
    }

    public void setUserCrseLevel(String userCrseLevel) {
        this.userCrseLevel = userCrseLevel == null ? null : userCrseLevel.trim();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
    
    
}