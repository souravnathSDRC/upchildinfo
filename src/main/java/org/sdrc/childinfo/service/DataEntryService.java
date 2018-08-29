package org.sdrc.childinfo.service;

import java.io.File;
import java.util.List;

import org.sdrc.childinfo.model.DataEntryModel;
import org.sdrc.childinfo.model.DataModel;
import org.sdrc.childinfo.model.IUSModel;
import org.sdrc.childinfo.model.ValueObject;
import org.sdrc.childinfo.util.CustomErrorMessageModel;

/**
 * 
 * @author subrata
 *
 */
public interface DataEntryService {
	
	public CustomErrorMessageModel excelFileUpload(byte[] bytes);
	
	public List<DataModel> getArea(); 

	public String downloadExcelFile(DataEntryModel dataEntryModel);

	public List<ValueObject> getSubsector();

	public List<IUSModel> getIUS(int id);

	public List<ValueObject> getTimePeriod(); 
	
	void createPreviousMonth();

	public File generateRawDataExcel(ValueObject timeperiodId);
	
	public String downloadFactsheet(DataEntryModel dataEntryModel);

}
