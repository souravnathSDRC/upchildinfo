package org.sdrc.childinfo.model;

import java.sql.Timestamp;
import java.util.List;

public class Block {
	
	private int blockId;
	private String blockCode;
	private String blockName;
	private String lastUpdatedBy;
	private Timestamp lastUpdatedDate;
	private ValueObject samikshyaDistrict;
	private List<Cluster> samikshyaClusters;
	/**
	 * @return the blockId
	 */
	public int getBlockId() {
		return blockId;
	}
	/**
	 * @param blockId the blockId to set
	 */
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	/**
	 * @return the blockCode
	 */
	public String getBlockCode() {
		return blockCode;
	}
	/**
	 * @param blockCode the blockCode to set
	 */
	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}
	/**
	 * @return the blockName
	 */
	public String getBlockName() {
		return blockName;
	}
	/**
	 * @param blockName the blockName to set
	 */
	public void setBlockName(String blockName) {
		this.blockName = blockName;
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
	 * @return the samikshyaDistrict
	 */
	public ValueObject getSamikshyaDistrict() {
		return samikshyaDistrict;
	}
	/**
	 * @param samikshyaDistrict the samikshyaDistrict to set
	 */
	public void setSamikshyaDistrict(ValueObject samikshyaDistrict) {
		this.samikshyaDistrict = samikshyaDistrict;
	}
	/**
	 * @return the samikshyaClusters
	 */
	public List<Cluster> getSamikshyaClusters() {
		return samikshyaClusters;
	}
	/**
	 * @param samikshyaClusters the samikshyaClusters to set
	 */
	public void setSamikshyaClusters(List<Cluster> samikshyaClusters) {
		this.samikshyaClusters = samikshyaClusters;
	}
}
