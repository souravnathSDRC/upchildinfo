package org.sdrc.childinfo.model;

import java.sql.Timestamp;

/**
 * The persistent class for the collection_status database table.
 * 
 */

public class CollectionStatusModel {

	private int id;

	private String areaCode;

	private String areaName;

	private Timestamp collectionEndTime;

	private Timestamp collectionStartTime;

	private String completionPer;

	private String completionStatus;

	private String lastUpdatedBy;

	private Timestamp lastUpdatedTime;
	
	private String cssClass;
	
	public CollectionStatusModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Timestamp getCollectionEndTime() {
		return this.collectionEndTime;
	}

	public void setCollectionEndTime(Timestamp collectionEndTime) {
		this.collectionEndTime = collectionEndTime;
	}

	public Timestamp getCollectionStartTime() {
		return this.collectionStartTime;
	}

	public void setCollectionStartTime(Timestamp collectionStartTime) {
		this.collectionStartTime = collectionStartTime;
	}

	public String getCompletionPer() {
		return this.completionPer;
	}

	public void setCompletionPer(String completionPer) {
		this.completionPer = completionPer;
	}

	public String getCompletionStatus() {
		return this.completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}