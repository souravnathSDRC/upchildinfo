package org.sdrc.childinfo.model;

import java.util.List;

public class State {

	private int stateId;
	private String stateCode;
	private String stateName;
	private List<District> samikshyaDistricts;

	/**
	 * @return the stateId
	 */
	public int getStateId() {
		return stateId;
	}

	/**
	 * @param stateId
	 *            the stateId to set
	 */
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode
	 *            the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName
	 *            the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the samikshyaDistricts
	 */
	public List<District> getSamikshyaDistricts() {
		return samikshyaDistricts;
	}

	/**
	 * @param samikshyaDistricts
	 *            the samikshyaDistricts to set
	 */
	public void setSamikshyaDistricts(List<District> samikshyaDistricts) {
		this.samikshyaDistricts = samikshyaDistricts;
	}
}
