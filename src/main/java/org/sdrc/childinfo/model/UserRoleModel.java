package org.sdrc.childinfo.model;

public class UserRoleModel {
	private int userId;
	private String userName;
	private int roleId;
	private String role;
	private String email;
	private String phone;
	private boolean status;
	private String block;
	private String district;
	private String areaCode;
	private int roleSchemeId;
	private String roleSchemeName;
	private String areaName;
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getRoleSchemeName() {
		return roleSchemeName;
	}
	public void setRoleSchemeName(String roleSchemeName) {
		this.roleSchemeName = roleSchemeName;
	}
	public int getRoleSchemeId() {
		return roleSchemeId;
	}
	public void setRoleSchemeId(int roleSchemeId) {
		this.roleSchemeId = roleSchemeId;
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
	public void setUserId(int i) {
		this.userId = i;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int i) {
		this.roleId = i;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean b) {
		this.status = b;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
}
