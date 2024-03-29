package com.yuzo.question.entity;

public class SysRole {
    private String roleId;

    private String roleName;

    private String roleState;

    private String roleInfo;
    
    private String roleSelected;
    
    
    

    @Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", roleState=" + roleState + ", roleInfo="
				+ roleInfo + ", roleSelected=" + roleSelected + "]";
	}

	public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleState() {
        return roleState;
    }

    public void setRoleState(String roleState) {
        this.roleState = roleState == null ? null : roleState.trim();
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo == null ? null : roleInfo.trim();
    }

	public String getRoleSelected() {
		return roleSelected;
	}

	public void setRoleSelected(String roleSelected) {
		this.roleSelected = roleSelected;
	}
    
}