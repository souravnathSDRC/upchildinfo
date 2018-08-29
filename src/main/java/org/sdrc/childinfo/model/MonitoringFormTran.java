package org.sdrc.childinfo.model;

import java.sql.Timestamp;

public class MonitoringFormTran {
	
	private int id;
	private String formPath;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private MonitoringForm monitoringForm;
	private String status;
	private String remarks;
	private boolean isActive;
	private String timePeriod;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the timePeriod
	 */
	public String getTimePeriod() {
		return timePeriod;
	}
	/**
	 * @param timePeriod the timePeriod to set
	 */
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the formPath
	 */
	public String getFormPath() {
		return formPath;
	}
	/**
	 * @param formPath the formPath to set
	 */
	public void setFormPath(String formPath) {
		this.formPath = formPath;
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
	 * @return the samikshyaMonitoringForm
	 */
	public MonitoringForm getMonitoringForm() {
		return monitoringForm;
	}
	/**
	 * @param samikshyaMonitoringForm the samikshyaMonitoringForm to set
	 */
	public void setSamikshyaMonitoringForm(MonitoringForm monitoringForm) {
		this.monitoringForm = monitoringForm;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	


}
