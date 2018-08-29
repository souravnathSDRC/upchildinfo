package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.List;

public class FeaturePermissionMapping {
	
	private int featurePermissionId;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private Feature feature;
	private Permission permission;
	private List<ValueObject> roleSchemes;
	
	/**
	 * @return the featurePermissionId
	 */
	public int getFeaturePermissionId() {
		return featurePermissionId;
	}
	/**
	 * @param featurePermissionId the featurePermissionId to set
	 */
	public void setFeaturePermissionId(int featurePermissionId) {
		this.featurePermissionId = featurePermissionId;
	}
	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	/**
	 * @return the lastUpdatedDate
	 */
	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	/**
	 * @return the feature
	 */
	public Feature getFeature() {
		return feature;
	}
	/**
	 * @param feature the feature to set
	 */
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	/**
	 * @return the permission
	 */
	public Permission getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	/**
	 * @return the roleSchemes
	 */
	public List<ValueObject> getRoleSchemes() {
		return roleSchemes;
	}
	/**
	 * @param roleSchemes the roleSchemes to set
	 */
	public void setRoleSchemes(List<ValueObject> roleSchemes) {
		this.roleSchemes = roleSchemes;
	}

}
