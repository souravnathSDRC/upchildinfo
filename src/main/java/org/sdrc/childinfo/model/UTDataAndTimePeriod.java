package org.sdrc.childinfo.model;

import java.util.List;

import org.sdrc.devinfo.domain.UtData;
import org.sdrc.devinfo.domain.UtTimeperiod;

public class UTDataAndTimePeriod {

	private List<UtData> datalist;
	private UtTimeperiod timeperiod;
	private boolean shouldSaveTimeperiod;
	
	public boolean isShouldSaveTimeperiod() {
		return shouldSaveTimeperiod;
	}
	public void setShouldSaveTimeperiod(boolean shouldSaveTimeperiod) {
		this.shouldSaveTimeperiod = shouldSaveTimeperiod;
	}
	public List<UtData> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<UtData> datalist) {
		this.datalist = datalist;
	}
	public UtTimeperiod getTimeperiod() {
		return timeperiod;
	}
	public void setTimeperiod(UtTimeperiod timeperiod) {
		this.timeperiod = timeperiod;
	}
	
	
}
