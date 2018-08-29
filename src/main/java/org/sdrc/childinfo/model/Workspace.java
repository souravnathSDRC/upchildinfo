package org.sdrc.childinfo.model;

import org.springframework.web.multipart.MultipartFile;

public class Workspace extends BaseModel {
	
	private MultipartFile file;
	
	private int monitoringFormId;
	
	private String formName;
	
	private String areaName;
	
	private String parentAreaName;
	
	private String areaCode;
	
	private String parentAreaCode;
	
	private String lastUpdatedUser;
	
	private String deadlineDate;
	
	private String status;
	
	private String remarks;
	
	private boolean shouldShowUploadButton;
	
	private boolean shouldShowDownloadButton;
	
	private boolean shouldAggregateButton;
	
	private boolean shouldShowBlankForm;
	
	private String blankFormPath;
	
	private String uploadedFormPath;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getMonitoringFormId() {
		return monitoringFormId;
	}

	public void setMonitoringFormId(int monitoringFormId) {
		this.monitoringFormId = monitoringFormId;
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

	public String getParentAreaName() {
		return parentAreaName;
	}

	public void setParentAreaName(String parentAreaName) {
		this.parentAreaName = parentAreaName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getParentAreaCode() {
		return parentAreaCode;
	}

	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}

	public String getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(String lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public String getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(String deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isShouldShowUploadButton() {
		return shouldShowUploadButton;
	}

	public void setShouldShowUploadButton(boolean shouldShowUploadButton) {
		this.shouldShowUploadButton = shouldShowUploadButton;
	}

	public boolean isShouldShowDownloadButton() {
		return shouldShowDownloadButton;
	}

	public void setShouldShowDownloadButton(boolean shouldShowDownloadButton) {
		this.shouldShowDownloadButton = shouldShowDownloadButton;
	}

	public boolean isShouldAggregateButton() {
		return shouldAggregateButton;
	}

	public void setShouldAggregateButton(boolean shouldAggregateButton) {
		this.shouldAggregateButton = shouldAggregateButton;
	}

	public boolean isShouldShowBlankForm() {
		return shouldShowBlankForm;
	}

	public void setShouldShowBlankForm(boolean shouldShowBlankForm) {
		this.shouldShowBlankForm = shouldShowBlankForm;
	}

	public String getBlankFormPath() {
		return blankFormPath;
	}

	public void setBlankFormPath(String blankFormPath) {
		this.blankFormPath = blankFormPath;
	}

	public String getUploadedFormPath() {
		return uploadedFormPath;
	}

	public void setUploadedFormPath(String uploadedFormPath) {
		this.uploadedFormPath = uploadedFormPath;
	}

}
