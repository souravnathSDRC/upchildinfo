package org.sdrc.childinfo.model;

import java.sql.Timestamp;

public class Cluster {
	
	
	private int clusterId;
	private String clusterCode;
	private String clusterName;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private ValueObject samikshyaBlock;
	/**
	 * @return the clusterId
	 */
	public int getClusterId() {
		return clusterId;
	}
	/**
	 * @param clusterId the clusterId to set
	 */
	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}
	/**
	 * @return the clusterCode
	 */
	public String getClusterCode() {
		return clusterCode;
	}
	/**
	 * @param clusterCode the clusterCode to set
	 */
	public void setClusterCode(String clusterCode) {
		this.clusterCode = clusterCode;
	}
	/**
	 * @return the clusterName
	 */
	public String getClusterName() {
		return clusterName;
	}
	/**
	 * @param clusterName the clusterName to set
	 */
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
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
	 * @return the samikshyaBlock
	 */
	public ValueObject getSamikshyaBlock() {
		return samikshyaBlock;
	}
	/**
	 * @param samikshyaBlock the samikshyaBlock to set
	 */
	public void setSamikshyaBlock(ValueObject samikshyaBlock) {
		this.samikshyaBlock = samikshyaBlock;
	}
	
}
