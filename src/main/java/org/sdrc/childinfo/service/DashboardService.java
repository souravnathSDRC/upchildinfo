package org.sdrc.childinfo.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.sdrc.childinfo.domain.CounterCount;
import org.sdrc.childinfo.model.LineSeries;
import org.sdrc.childinfo.model.UtDataCollection;
import org.sdrc.childinfo.model.UtDataModel;
import org.sdrc.childinfo.model.ValueObject;

public interface DashboardService {

	List<ValueObject> fetchIndicators(String indicatorType);
	
//	List<ValueObject> fetchIndicators(String param,String parentAreaCode,Integer level);
	
	List<ValueObject> fetchSources(String param);	
	
	List<ValueObject> fetchSourcesByLevel(String param,Integer childLevel);	

//	List<ValueObject> fetchTimeFormats() throws ParseException;
	
	List<ValueObject> fetchUtTimeperiod(Integer iusNid,Integer SourceNid);
	
	List<ValueObject> fetchAllSectors(String ic_type);
	
	UtDataCollection fetchData(String indicatorId,String sourceId, String parentAreaCode, String timeperiodId , Integer childLevel) throws ParseException;

	UtDataCollection fetchComputeData(String indicatorId, String parentAreaCode, String timeperiodId , Integer childLevel,Integer sourceNId) throws ParseException;
	
	UtDataCollection fetchBurdenData(Integer iusNIdForProjection,Integer iusNId,Integer iusNIdForIMRorU5MR, String parentAreaCode, String timeperiodId , Integer childLevel,Integer sourceNIdForProjection,Integer sourceNId,Integer sourceNIdForIMRorU5MR) throws ParseException;
	
	List<List<LineSeries>> fetchChartData(Integer iusNid, Integer areaNid) throws ParseException;

	List<List<Map<Object, String>>> fetchColChartData(Integer iusNid, Integer areaNid);

	List<UtDataModel> fetchPdfData(String indicatorId, String sourceId,
			String areaId, String timePeriodId, Integer childLevel);
	
	CounterCount getCounter();
	
	CounterCount fetchCounter();
}
