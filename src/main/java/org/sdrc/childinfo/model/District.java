package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.List;

public class District {
	
	private int districtId;
	private String districtCode;
	private String districtName;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private List<Block> samikshyaBlocks;
	private ValueObject samikshyaState;
	/**
	 * @return the districtId
	 */
	public int getDistrictId() {
		return districtId;
	}
	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	/**
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}
	/**
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}
	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
	 * @return the samikshyaBlocks
	 */
	public List<Block> getSamikshyaBlocks() {
		return samikshyaBlocks;
	}
	/**
	 * @param samikshyaBlocks the samikshyaBlocks to set
	 */
	public void setSamikshyaBlocks(List<Block> samikshyaBlocks) {
		this.samikshyaBlocks = samikshyaBlocks;
	}
	/**
	 * @return the samikshyaState
	 */
	public ValueObject getSamikshyaState() {
		return samikshyaState;
	}
	/**
	 * @param samikshyaState the samikshyaState to set
	 */
	public void setSamikshyaState(ValueObject samikshyaState) {
		this.samikshyaState = samikshyaState;
	}
}
