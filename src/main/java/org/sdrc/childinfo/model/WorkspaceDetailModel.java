package org.sdrc.childinfo.model;

public class WorkspaceDetailModel {

	private String id;
	private int count;
	private String submission_date;
	private String formID;
	private String areaName;
	private String district;
	private int level;
	private String facility;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	public String getFormID() {
		return formID;
	}
	public void setFormID(String formID) {
		this.formID = formID;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getFacility() {
		return this.facility;
	}
	
}
