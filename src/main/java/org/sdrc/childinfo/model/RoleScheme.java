package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.List;

public class RoleScheme {
	
	private int roleSchemeId;
	private String areaCode;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private String roleSchemeName;
	private FeaturePermissionMapping featurePermissionMapping;
	private Role samikshyaRole;
	private List<ValueObject> userRoleSchemeMappings;
	
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
	public String getRoleSchemeName() {
		return roleSchemeName;
	}
	public void setRoleSchemeName(String roleSchemeName) {
		this.roleSchemeName = roleSchemeName;
	}
	public FeaturePermissionMapping getFeaturePermissionMapping() {
		return featurePermissionMapping;
	}
	public void setFeaturePermissionMapping(
			FeaturePermissionMapping featurePermissionMapping) {
		this.featurePermissionMapping = featurePermissionMapping;
	}
	public Role getSamikshyaRole() {
		return samikshyaRole;
	}
	public void setSamikshyaRole(Role samikshyaRole) {
		this.samikshyaRole = samikshyaRole;
	}
	public List<ValueObject> getUserRoleSchemeMappings() {
		return userRoleSchemeMappings;
	}
	public void setUserRoleSchemeMappings(
			List<ValueObject> userRoleSchemeMappings) {
		this.userRoleSchemeMappings = userRoleSchemeMappings;
	}

}
