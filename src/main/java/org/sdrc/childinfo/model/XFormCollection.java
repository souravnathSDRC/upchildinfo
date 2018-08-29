package org.sdrc.childinfo.model;

import java.util.List;

public class XFormCollection {

	public String form_id;
	public String form_name;
	public String instanceID;
	public String submission_date;
	public String areaCode;
	public String district;
	public String facility;
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	List<XFormDefinitionModel> definitionList;
	
	
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public String getForm_name() {
		return form_name;
	}
	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}
	public List<XFormDefinitionModel> getDefinitionList() {
		return definitionList;
	}
	public void setDefinitionList(List<XFormDefinitionModel> definitionList) {
		this.definitionList = definitionList;
	}
	public String getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}
	public String getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getFacility() {
		return this.facility;
	}
	
}
