package org.sdrc.childinfo.model;

public class Status {

	private String activeStatus;
	private int userId;
	private String areaCode;
	private int roleId;
	private int roleSchemeId;
	private String email;
	private String nameOfUser;
	private String areaName;
	private String roleName;
	private String roleSchemeName;
	public String getRoleSchemeName() {
		return roleSchemeName;
	}

	public void setRoleSchemeName(String roleSchemeName) {
		this.roleSchemeName = roleSchemeName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleSchemeId() {
		return roleSchemeId;
	}

	public void setRoleSchemeId(int roleSchemeId) {
		this.roleSchemeId = roleSchemeId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	
}
