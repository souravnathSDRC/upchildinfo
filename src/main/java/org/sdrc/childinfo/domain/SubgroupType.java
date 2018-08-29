package org.sdrc.childinfo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 *
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in) on 31-Dec-2016 2:03:00 pm
 */
@Entity
public class SubgroupType {
	

	@Id
	private int subgroupId;
	private int id;
	private String name;
	private int area;
	private String timeperiod_name;
	private int timeperiod_id;
	private String source_name;
	private int source_id;
	private int indicator;
	private int ic;
	private boolean is_total;
	private Double value;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getIndicator() {
		return indicator;
	}
	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}
	public int getIc() {
		return ic;
	}
	public void setIc(int ic) {
		this.ic = ic;
	}
	public boolean isIs_total() {
		return is_total;
	}
	public void setIs_total(boolean is_total) {
		this.is_total = is_total;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public String getTimeperiod_name() {
		return timeperiod_name;
	}
	public void setTimeperiod_name(String timeperiod_name) {
		this.timeperiod_name = timeperiod_name;
	}
	public int getTimeperiod_id() {
		return timeperiod_id;
	}
	public void setTimeperiod_id(int timeperiod_id) {
		this.timeperiod_id = timeperiod_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubgroupId() {
		return subgroupId;
	}
	public void setSubgroupId(int subgroupId) {
		this.subgroupId = subgroupId;
	}
}
