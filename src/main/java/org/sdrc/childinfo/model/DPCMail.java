package org.sdrc.childinfo.model;

public class DPCMail extends Mail {
	private String blockcode;
	private String districtcode;
	private String timeperiod;
	private String status;
	private String remark;
	
	public String getBlockcode() {
		return blockcode;
	}
	public void setBlockcode(String blockcode) {
		this.blockcode = blockcode;
	}
	public String getDistrictcode() {
		return districtcode;
	}
	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
	}
	public String getTimeperiod() {
		return timeperiod;
	}
	public void setTimeperiod(String timeperiod) {
		this.timeperiod = timeperiod;
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
	
}
