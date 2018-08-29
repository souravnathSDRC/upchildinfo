package org.sdrc.childinfo.service;

import java.text.ParseException;
import java.util.List;

import org.sdrc.childinfo.model.IUSValueObject;
import org.sdrc.childinfo.model.UtDataCollection;

public interface ComputationService {
	
	List<Object[]> fetchIndicatorAndUnitBySectorNId(String sectorNId);	
	
	List<Object[]> fetchSubgroupByIndicatorAndUnit(Integer indicatorNId,Integer unitNId);
	
	UtDataCollection fetchCompositeIndexData(List<IUSValueObject> iusDataModelList, String parentAreaCode, Integer childLevel) throws ParseException;

}
