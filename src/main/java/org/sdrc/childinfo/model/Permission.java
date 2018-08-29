package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.List;

public class Permission {
	
	private int permissionId;
	private String description;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private String permissionCode;
	private String permissionName;
	private List<ValueObject> featurePermissionMappings;
	
	/**
	 * @return the permissionId
	 */
	public int getPermissionId() {
		return permissionId;
	}
	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the permissionCode
	 */
	public String getPermissionCode() {
		return permissionCode;
	}
	/**
	 * @param permissionCode the permissionCode to set
	 */
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
	/**
	 * @return the permissionName
	 */
	public String getPermissionName() {
		return permissionName;
	}
	/**
	 * @param permissionName the permissionName to set
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	/**
	 * @return the featurePermissionMappings
	 */
	public List<ValueObject> getFeaturePermissionMappings() {
		return featurePermissionMappings;
	}
	/**
	 * @param featurePermissionMappings the featurePermissionMappings to set
	 */
	public void setFeaturePermissionMappings(
			List<ValueObject> featurePermissionMappings) {
		this.featurePermissionMappings = featurePermissionMappings;
	}

}
