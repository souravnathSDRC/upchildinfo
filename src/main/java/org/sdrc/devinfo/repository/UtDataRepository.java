package org.sdrc.devinfo.repository;

import java.util.List;

import org.sdrc.devinfo.domain.UtAreaEn;
import org.sdrc.devinfo.domain.UtData;
import org.sdrc.devinfo.domain.UtTimeperiod;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public interface UtDataRepository {

//	List<Object[]> findData(Integer indicatorId, String[] areaCode,Integer childLevel);

	List<Object[]> findDataByTimePeriod(Integer indicatorId,
			Integer timePeriodNid,Integer sourceNid, Integer[] areaNid);
	
	List<Object[]> findComputeDataByTimePeriod(Integer indicatorId,
			Integer timePeriodNid, Integer[] areaNid,Integer unitNId,Integer subgroupValNId);
	
	
	List<Object[]> findDataForCompositeIndex(Integer iusNId,
			Integer timePeriodNid,Integer[] areaNid);
	
	List<UtTimeperiod> findTimePeriodNIdByDecadeTimePeriod(List<String> timePeriodNid);
	
	@Transactional
	void save(UtData data);

	UtData findByIUSNIdAndAreaNidAndTimePeriodNidAndSourcNid(int IUSNId,
			int areaNid, int timeNid, int sourceNid) throws DataAccessException;

	void updateDataValue(Double data_Value, int IUSNId, int areaNid,
			int timeNid, int sourceNid) throws DataAccessException;

	List<Object[]> findByIUSNIdAndTimePeriodNidAndSourceNidAndAreaLevel(
			int IUSNId, int timeNid, int sourceNid, int areaLevel)
			throws DataAccessException;

	List<Object[]> findDataValueByAreaLevel(int IUSNId, int timeNid,
			int sourceNid, int areaLevel) throws DataAccessException;

	Double getDataValueForBlock(int ius_nid, int timeperiod_nid,
			int source_nid, int area_NId);

	Double getDataValueForDistrict(int ius_nid, Integer timeperiod_nid,
			int source_nid, String areaCode);

	Double getAggregatedDataValueByAreaCode(int iusNid, int timePeriodNid,
			int sourceNid, String areaId) throws DataAccessException;

	UtAreaEn[] getAreaNid(String areaId, Integer childLevel);

	/**
	 * fetching ut_data
	 * @param indicatorId
	 * @param areaNid
	 * @param sourceNid
	 * @return
	 */
	List<Object[]> findData(Integer indicatorId, Integer areaNid);
	
	Double getOverAllscore(int timePeriodNid,int sourceNid,int areaNid,String iCName) throws DataAccessException;
	
	Double getOverAllscoreForSectors(int timePeriodNid,int sourceNid,int areaNid,Integer[] iusNids) throws DataAccessException;

	Double getAverageDataValueByAreaCode(int iusNid,int timePeriodNid,int sourceNid,String areaId) throws DataAccessException;
	
	public List<Object[]> findDataByTimeAndAreaId( Integer indicatorId, String areaId, String timeperiod);
	
	List<UtData> findAll();

	@Transactional
	void save(Iterable<UtData> utDatas);

	List<UtData> getData(int subSector, int timePeriod, int indicator, int unit, int subgroup);

	/**
	 * @param timeperiodId
	 * @return
	 */
	List<Object[]> getByTimePeriod(int timeperiodId);
	
	List<Object[]> findDataByTimePeriodAndArea(Integer timeperiodId, List<Integer> areaList, Integer[] iusIds);
	
	public List<Object[]> getABRCCData(List<String> areaNames);

}
