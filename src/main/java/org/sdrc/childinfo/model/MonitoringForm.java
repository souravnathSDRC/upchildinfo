package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.List;

public class MonitoringForm {
	

	
	private int id;
	private String formCode;
	private String formPath;
	private String formType;
	private String isActive;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private String version;
	private Block samikshyaBlock;
	private Cluster samikshyaCluster;
	private District samikshyaDistrict;
	private State samikshyaState;
	private List<ValueObject> samikshyaMonitoringFormTrans;
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
	 * @return the formCode
	 */
	public String getFormCode() {
		return formCode;
	}
	/**
	 * @param formCode the formCode to set
	 */
	public void setFormCode(String formCode) {
		this.formCode = formCode;
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
	 * @return the formType
	 */
	public String getFormType() {
		return formType;
	}
	/**
	 * @param formType the formType to set
	 */
	public void setFormType(String formType) {
		this.formType = formType;
	}
	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the samikshyaBlock
	 */
	public Block getSamikshyaBlock() {
		return samikshyaBlock;
	}
	/**
	 * @param samikshyaBlock the samikshyaBlock to set
	 */
	public void setSamikshyaBlock(Block samikshyaBlock) {
		this.samikshyaBlock = samikshyaBlock;
	}
	/**
	 * @return the samikshyaCluster
	 */
	public Cluster getSamikshyaCluster() {
		return samikshyaCluster;
	}
	/**
	 * @param samikshyaCluster the samikshyaCluster to set
	 */
	public void setSamikshyaCluster(Cluster samikshyaCluster) {
		this.samikshyaCluster = samikshyaCluster;
	}
	/**
	 * @return the samikshyaDistrict
	 */
	public District getSamikshyaDistrict() {
		return samikshyaDistrict;
	}
	/**
	 * @param samikshyaDistrict the samikshyaDistrict to set
	 */
	public void setSamikshyaDistrict(District samikshyaDistrict) {
		this.samikshyaDistrict = samikshyaDistrict;
	}
	/**
	 * @return the samikshyaState
	 */
	public State getSamikshyaState() {
		return samikshyaState;
	}
	/**
	 * @param samikshyaState the samikshyaState to set
	 */
	public void setSamikshyaState(State samikshyaState) {
		this.samikshyaState = samikshyaState;
	}
	/**
	 * @return the samikshyaMonitoringFormTrans
	 */
	public List<ValueObject> getSamikshyaMonitoringFormTrans() {
		return samikshyaMonitoringFormTrans;
	}
	/**
	 * @param samikshyaMonitoringFormTrans the samikshyaMonitoringFormTrans to set
	 */
	public void setSamikshyaMonitoringFormTrans(
			List<ValueObject> samikshyaMonitoringFormTrans) {
		this.samikshyaMonitoringFormTrans = samikshyaMonitoringFormTrans;
	}
	
}
