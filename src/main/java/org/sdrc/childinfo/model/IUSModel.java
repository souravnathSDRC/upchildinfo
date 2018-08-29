package org.sdrc.childinfo.model;

/**
 * 
 * @author subrata
 *
 */
public class IUSModel {
	
	private Integer iusNId;
	private String iusName;
	private Integer indicatorId;
	private String indicatorName;
	private Integer unitId;
	private String unitName;
	private Integer subgroupId;
	private String subgroupName;
	private boolean isSelected;
	
	public Integer getIusNId() {
		return iusNId;
	}
	public void setIusNId(Integer iusNId) {
		this.iusNId = iusNId;
	}
	public String getIusName() {
		return iusName;
	}
	public void setIusName(String iusName) {
		this.iusName = iusName;
	}
	public Integer getIndicatorId() {
		return indicatorId;
	}
	public void setIndicatorId(Integer indicatorId) {
		this.indicatorId = indicatorId;
	}
	public String getIndicatorName() {
		return indicatorName;
	}
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Integer getSubgroupId() {
		return subgroupId;
	}
	public void setSubgroupId(Integer subgroupId) {
		this.subgroupId = subgroupId;
	}
	public String getSubgroupName() {
		return subgroupName;
	}
	public void setSubgroupName(String subgroupName) {
		this.subgroupName = subgroupName;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

}
