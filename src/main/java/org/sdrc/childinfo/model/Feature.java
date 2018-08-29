package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.List;

public class Feature {
	
	private int featureId;
	private String description;
	private String featureCode;
	private String featureName;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private List<ValueObject> featurePermissionMappings;
	
	public int getFeatureId() {
		return featureId;
	}
	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFeatureCode() {
		return featureCode;
	}
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
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
	public List<ValueObject> getFeaturePermissionMappings() {
		return featurePermissionMappings;
	}
	public void setFeaturePermissionMappings(
			List<ValueObject> featurePermissionMappings) {
		this.featurePermissionMappings = featurePermissionMappings;
	}

}
