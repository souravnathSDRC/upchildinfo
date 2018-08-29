package org.sdrc.childinfo.model;
/**
 * 
 * @author subrata
 *
 */
public class DataModel {
	
	private String areaCode;
	private String level;
	private int arealevel;
	private int areaNId;
	private String areaName;
	private int areaParentNId;
	private Boolean isVisible;
	private Boolean isSelected;
	
	public String getAreaCode() {
		return areaCode;
	}
	public int getArealevel() {
		return arealevel;
	}
	public void setArealevel(int arealevel) {
		this.arealevel = arealevel;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getAreaParentNId() {
		return areaParentNId;
	}
	public void setAreaParentNId(int areaParentNId) {
		this.areaParentNId = areaParentNId;
	}
	public Boolean getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Boolean getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	public int getAreaNId() {
		return areaNId;
	}
	public void setAreaNId(int areaNId) {
		this.areaNId = areaNId;
	}
	
}
