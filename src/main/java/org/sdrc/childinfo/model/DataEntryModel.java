package org.sdrc.childinfo.model;

import java.util.List;

/**
 * 
 * @author subrata
 *
 */
public class DataEntryModel {
	
	private ValueObject timePeriod;
	private ValueObject sector;
	private ValueObject program;
	private List<IUSModel> iusModel;
	private List<DataModel> dataModel;
	private String dataProvided;
	private ValueObject userDetails;
	
	public ValueObject getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(ValueObject timePeriod) {
		this.timePeriod = timePeriod;
	}
	public ValueObject getSector() {
		return sector;
	}
	public void setSector(ValueObject sector) {
		this.sector = sector;
	}
	public ValueObject getProgram() {
		return program;
	}
	public void setProgram(ValueObject program) {
		this.program = program;
	}
	public List<IUSModel> getIusModel() {
		return iusModel;
	}
	public void setIusModel(List<IUSModel> iusModel) {
		this.iusModel = iusModel;
	}
	public List<DataModel> getDataModel() {
		return dataModel;
	}
	public void setDataModel(List<DataModel> dataModel) {
		this.dataModel = dataModel;
	}
	public String getDataProvided() {
		return dataProvided;
	}
	public void setDataProvided(String dataProvided) {
		this.dataProvided = dataProvided;
	}
	public ValueObject getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(ValueObject userDetails) {
		this.userDetails = userDetails;
	}
	
}
