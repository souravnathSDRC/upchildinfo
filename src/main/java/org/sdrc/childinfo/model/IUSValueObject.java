package org.sdrc.childinfo.model;

public class IUSValueObject {
	private Integer iusid;
	private String indicator;
	private String unit;
	private String subgroup;
	private String weight;
	private boolean highisgood;
	public Integer getIusid() {
		return iusid;
	}
	public void setIusid(Integer iusid) {
		this.iusid = iusid;
	}
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSubgroup() {
		return subgroup;
	}
	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public boolean isHighisgood() {
		return highisgood;
	}
	public void setHighisgood(boolean highisgood) {
		this.highisgood = highisgood;
	}
	@Override
	public String toString() {
		return "IUSValueObject [iusid=" + iusid +"indicator=" + indicator + "subgroup=" + subgroup+", subgroup=" + subgroup
				+ ", weight=" + weight + ", highisgood="+ highisgood +"]";
	}
}
