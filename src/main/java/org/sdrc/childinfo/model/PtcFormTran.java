package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PtcFormTran {
	private int tranId;
	private String formName;
	private String areaName;
	private Timestamp lastUpdatedDate;
	private String status;
	private String remark;
	private String downloadPath;
	private String timePeriod;
	private ArrayList<String> timePeriodList;
	private String areaCode;
	private int districtId;
	private int monitoringFormId;
	
	public int getMonitoringFormId() {
		return monitoringFormId;
	}
	public void setMonitoringFormId(int monitoringFormId) {
		this.monitoringFormId = monitoringFormId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public ArrayList<String> getTimePeriodList() {
		return timePeriodList;
	}
	public void setTimePeriodList(ArrayList<String> timePeriodList) {
		this.timePeriodList = timePeriodList;
	}
	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	

}
