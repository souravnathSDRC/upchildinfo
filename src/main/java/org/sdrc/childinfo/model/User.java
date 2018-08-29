package org.sdrc.childinfo.model;

import java.util.Date;
import java.util.List;

public class User {
	
	private int userId;
	private String lastUpdatedBy;
	private Date lastUpdatedDate;
	private String userContactNo;
	private String userEmailId;
	private String userName;
	private boolean active;
	private List<UserRoleSchemeMapping> userRoleSchemeMappings;
	
	
	public List<UserRoleSchemeMapping> getUserRoleSchemeMappings() {
		return userRoleSchemeMappings;
	}
	public void setUserRoleSchemeMappings(
			List<UserRoleSchemeMapping> userRoleSchemeMappings) {
		this.userRoleSchemeMappings = userRoleSchemeMappings;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserContactNo() {
		return userContactNo;
	}
	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}


}
