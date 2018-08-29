package org.sdrc.childinfo.model;

import java.sql.Timestamp;

public class UserRoleSchemeMapping {
	
	private int userRoleSchemeId;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private RoleScheme roleScheme;
	private ValueObject user;
	
	public int getUserRoleSchemeId() {
		return userRoleSchemeId;
	}
	public void setUserRoleSchemeId(int userRoleSchemeId) {
		this.userRoleSchemeId = userRoleSchemeId;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public RoleScheme getRoleScheme() {
		return roleScheme;
	}
	public void setRoleScheme(RoleScheme roleScheme) {
		this.roleScheme = roleScheme;
	}
	/**
	 * @return the user
	 */
	public ValueObject getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(ValueObject user) {
		this.user = user;
	}
	
	
	

}
