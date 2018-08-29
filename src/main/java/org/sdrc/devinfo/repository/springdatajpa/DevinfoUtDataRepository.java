package org.sdrc.devinfo.repository.springdatajpa;

import java.util.List;

import org.sdrc.devinfo.domain.UtAreaEn;
import org.sdrc.devinfo.domain.UtData;
import org.sdrc.devinfo.domain.UtTimeperiod;
import org.sdrc.devinfo.repository.UtDataRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DevinfoUtDataRepository extends UtDataRepository,Repository<UtData, Long> {
	
	/**
	 * Fetching data from Ut_Data, combination of data, area, time period, source
	 */
	@Override
	@Query("SELECT utData , utArea , utTimePeriod , source FROM UtAreaEn utArea,UtData utData, UtTimeperiod utTimePeriod, UtIndicatorClassificationsEn source "
			+ "WHERE utArea.area_NId = utData.area_NId AND "
			+ "utData.timePeriod_NId = utTimePeriod.timePeriod_NId AND "
			+ "utData.source_NId = source.IC_NId AND "
			+ "utArea.area_NId = :areaNid AND "
			+ "utData.IUSNId = :indicatorId "
			+ "ORDER BY utArea.area_ID,utTimePeriod.timePeriod")
	public List<Object[]> findData(@Param("indicatorId") Integer indicatorId,@Param("areaNid") Integer areaNid);
	
	/**
	 * Fetches UtAreaEns between two levels of area i.e childLevel as 2nd
	 * parameter and areaLevel for areaCode(parent) as 1st parameter. Both the
	 * levels are inclusive. So this method results child areas for given
	 * areaCode and their parent area.
	 */
	@Override
	@Query("SELECT ar FROM UtAreaEn ar WHERE ar.area_Level <= :childLevel AND ar.area_Level >=   "
			+ "(SELECT parArea.area_Level FROM UtAreaEn parArea WHERE parArea.area_ID = :areaId)")
	public UtAreaEn[] getAreaNid(@Param("areaId") String areaCode,@Param("childLevel")Integer childLevel);

	
	@Override
	@Query("SELECT utData , utArea , utTimePeriod FROM UtAreaEn utArea,UtData utData, UtTimeperiod utTimePeriod "
			+ "WHERE utArea.area_NId = utData.area_NId AND "
			+ "utData.timePeriod_NId = utTimePeriod.timePeriod_NId AND"
			+ " utArea.area_NId "
			+ "IN "
			+ "(:areaNid) AND "
			+ " utData.timePeriod_NId = :timeperiodId AND "
			+ " utData.source_NId = :sourceNid AND "
			+ " utData.IUSNId = :indicatorId " 
			+ " ORDER BY utData.data_Value")
	public List<Object[]> findDataByTimePeriod(@Param("indicatorId") Integer indicatorId,@Param("timeperiodId") Integer timeperiodId,@Param("sourceNid") Integer sourceNid,@Param("areaNid") Integer[] areaNid);

	@Override
	@Query("SELECT utData , utArea , utTimePeriod FROM UtAreaEn utArea,UtData utData, UtTimeperiod utTimePeriod "
			+ "WHERE utArea.area_NId = utData.area_NId AND "
			+ "utData.timePeriod_NId = utTimePeriod.timePeriod_NId AND"
			+ " utArea.area_NId "
			+ "IN "
			+ "(:areaNid) AND "
			+ " utData.timePeriod_NId = :timeperiodId AND "
			+ " utData.indicator_NId = :indicatorId AND " 
			+ " utData.unit_NId = :unitNId AND "
			+ " utData.subgroup_Val_NId = :subgroupValNId "
			+ " ORDER BY utData.data_Value")
	public List<Object[]> findComputeDataByTimePeriod(@Param("indicatorId") Integer indicatorId,@Param("timeperiodId") Integer timeperiodId,@Param("areaNid") Integer[] areaNid,@Param("unitNId") Integer unitNId,@Param("subgroupValNId") Integer subgroupValNId);
//,@Param("unitNId") Integer unitNId,@Param("subgroupValNId") Integer subgroupValNId
	@Override
	@Query("SELECT utTimePeriod FROM UtTimeperiod utTimePeriod "
			+ "WHERE utTimePeriod.timePeriod IN (:decadetimeperiodId)")
	public List<UtTimeperiod> findTimePeriodNIdByDecadeTimePeriod(@Param("decadetimeperiodId") List<String> decadetimeperiodId);
	

	@Override
	@Query("SELECT utData , utArea , utTimePeriod FROM UtAreaEn utArea,UtData utData, UtTimeperiod utTimePeriod "
			+ "WHERE utArea.area_NId = utData.area_NId AND "
			+ "utData.timePeriod_NId = utTimePeriod.timePeriod_NId AND"
			+ " utArea.area_NId "
			+ "IN "
			+ "(:areaNid) AND "
			+ " utData.timePeriod_NId = :timeperiodId AND "
			+ " utData.IUSNId = :iusNId " 
			+ " ORDER BY utData.data_Value")
	public List<Object[]> findDataForCompositeIndex(@Param("iusNId") Integer iusNId,@Param("timeperiodId") Integer timeperiodId,@Param("areaNid") Integer[] areaNid);

	
			
	@Query("select area.area_ID,area.area_Name, ar.area_ID, ar.area_Name from UtAreaEn area , UtAreaEn ar where ar.area_NId = area.area_Parent_NId")
	public List<Object[]> findByAreaCode();

	@Override
	@Query("SELECT data FROM UtData data WHERE data.IUSNId=:IUSNId "
			+ "AND data.area_NId=:area_NId "
			+ "AND data.timePeriod_NId=:timePeriod_NId "
			+ "AND data.source_NId=:source_NId")
	UtData findByIUSNIdAndAreaNidAndTimePeriodNidAndSourcNid(
			@Param("IUSNId") int IUSNId, @Param("area_NId") int areaNid,
			@Param("timePeriod_NId") int timeNid,
			@Param("source_NId") int sourceNid) throws DataAccessException;

	@Override
	@Modifying
	@Query("UPDATE UtData data SET data.data_Value=:data_Value WHERE data.IUSNId=:IUSNId "
			+ "AND data.area_NId=:area_NId AND data.timePeriod_NId=:timePeriod_NId "
			+ "AND data.source_NId=:source_NId")
	@Transactional
	void updateDataValue(@Param("data_Value") Double data_Value,
			@Param("IUSNId") int IUSNId, @Param("area_NId") int areaNid,
			@Param("timePeriod_NId") int timeNid,
			@Param("source_NId") int sourceNid) throws DataAccessException;

	@Override
	@Query("SELECT utData , utArea  FROM UtAreaEn utArea,UtData utData "
			+ " WHERE utArea.area_NId = utData.area_NId "
			+ " AND utArea.area_Level = :area_Level "
			+ " AND utData.timePeriod_NId = :timePeriod_NId "
			+ " AND utData.IUSNId = :IUSNId "
			+ " AND utData.source_NId=:source_NId ORDER BY utData.data_Value")
	List<Object[]> findByIUSNIdAndTimePeriodNidAndSourceNidAndAreaLevel(
			@Param("IUSNId") int IUSNId, @Param("timePeriod_NId") int timeNid,
			@Param("source_NId") int sourceNid,
			@Param("area_Level") int areaLevel) throws DataAccessException;

	@Override
	@Query("SELECT utArea.area_Parent_NId,utArea.area_NId,utArea.area_Name,utData.data_Value FROM UtAreaEn utArea,UtData utData "
			+ " WHERE utArea.area_NId = utData.area_NId "
			+ " AND utArea.area_Level = :area_Level "
			+ " AND utData.timePeriod_NId = :timePeriod_NId "
			+ " AND utData.IUSNId = :IUSNId "
			+ " AND utData.source_NId=:source_NId ORDER BY utData.data_Value")
	List<Object[]> findDataValueByAreaLevel(@Param("IUSNId") int IUSNId,
			@Param("timePeriod_NId") int timeNid,
			@Param("source_NId") int sourceNid,
			@Param("area_Level") int areaLevel) throws DataAccessException;

	@Override
	@Query("SELECT data_Value FROM UtData WHERE IUSNId=:ius_nid AND timePeriod_NId=:timeperiod_nid AND source_NId=:source_nid AND area_NId=:area_NId")
	Double getDataValueForBlock(@Param("ius_nid") int ius_nid,
			@Param("timeperiod_nid") int timeperiod_nid,
			@Param("source_nid") int source_nid, @Param("area_NId") int area_NId);
	
	@Override
	@Query("SELECT u.data_Value FROM UtData u WHERE u.IUSNId=:ius_nid AND u.timePeriod_NId=:timeperiod_nid AND u.source_NId=:source_nid AND u.area_NId=(SELECT a.area_NId From UtAreaEn a where a.area_ID=:areaCode)")
	Double getDataValueForDistrict(@Param("ius_nid")int ius_nid,@Param("timeperiod_nid") Integer timeperiod_nid,@Param("source_nid")int source_nid,@Param("areaCode") String areaCode);
	
	@Override
	@Query("SELECT SUM(utData.data_Value) FROM UtData utData "
			+ " WHERE utData.area_NId IN (SELECT utArea.area_NId FROM UtAreaEn utArea WHERE utArea.area_Parent_NId=(SELECT utArea.area_NId FROM UtAreaEn utArea WHERE utArea.area_ID=:area_ID)) "
			+ " AND utData.IUSNId=:IUSNId "
			+ " AND utData.timePeriod_NId=:timePeriod_NId "
			+ " AND utData.source_NId=:source_NId")
	Double getAggregatedDataValueByAreaCode(@Param("IUSNId")int iusNid,@Param("timePeriod_NId")int timePeriodNid,@Param("source_NId")int sourceNid,@Param("area_ID")String areaId) throws DataAccessException;
	
	@Override
	@Query("SELECT ROUND(AVG(utData.data_Value),1) FROM UtData utData "
			+ " WHERE utData.IUSNId IN (SELECT utIus.IUSNId FROM UtIndicatorUnitSubgroup utIus , UtIcIus icIus , UtIndicatorClassificationsEn classificationsEn"
			+ " where utIus.IUSNId=icIus.IUSNId AND icIus.IC_NId=classificationsEn.IC_NId AND classificationsEn.IC_Type='SC' "
			+ " AND classificationsEn.IC_Name=:IC_Name AND utIus.unit_NId=2)"
			+ " AND utData.timePeriod_NId=:timePeriod_NId"
			+ " AND utData.source_NId=:source_NId"
			+ " AND utData.area_NId=:area_NId")
	Double getOverAllscore(@Param("timePeriod_NId")int timePeriodNid,@Param("source_NId")int sourceNid,@Param("area_NId")int areaNid,@Param("IC_Name")String iCName) throws DataAccessException;
	
	@Override
	@Query("SELECT ROUND(AVG(utData.data_Value),1) FROM UtData utData "
			+ " WHERE utData.IUSNId IN (:IUSNIds)"
			+ " AND utData.timePeriod_NId=:timePeriod_NId"
			+ " AND utData.source_NId=:source_NId"
			+ " AND utData.area_NId=:area_NId")
	Double getOverAllscoreForSectors(@Param("timePeriod_NId")int timePeriodNid,@Param("source_NId")int sourceNid,@Param("area_NId")int areaNid,@Param("IUSNIds")Integer[] iusNids) throws DataAccessException;
	
	@Override
	@Query("SELECT ROUND(AVG(utData.data_Value),1) FROM UtData utData "
			+ " WHERE utData.area_NId IN (SELECT utArea.area_NId FROM UtAreaEn utArea WHERE utArea.area_Parent_NId=(SELECT utArea.area_NId FROM UtAreaEn utArea WHERE utArea.area_ID=:area_ID)) "
			+ " AND utData.IUSNId=:IUSNId "
			+ " AND utData.timePeriod_NId=:timePeriod_NId "
			+ " AND utData.source_NId=:source_NId")
	Double getAverageDataValueByAreaCode(@Param("IUSNId")int iusNid,@Param("timePeriod_NId")int timePeriodNid,@Param("source_NId")int sourceNid,@Param("area_ID")String areaId) throws DataAccessException;
	
	/**
	 * Fetching data from Ut_Data, combination of data, area, time period, source
	 */
	@Override
	@Query("SELECT utData , source FROM UtAreaEn utArea,UtData utData, UtTimeperiod utTimePeriod, UtIndicatorClassificationsEn source "
			+ "WHERE utArea.area_NId = utData.area_NId AND "
			+ "utData.timePeriod_NId = utTimePeriod.timePeriod_NId AND "
			+ "utData.source_NId = source.IC_NId AND "
			+ "utArea.area_ID = :areaId  AND "
			+ "utData.IUSNId = :indicatorId AND "
			+ "utTimePeriod.timePeriod = :timeperiod")
	public List<Object[]> findDataByTimeAndAreaId(@Param("indicatorId") Integer indicatorId,@Param("areaId") String areaId,@Param("timeperiod") String timeperiod);
	
	@Override
	@Query(value="select ud from UtData ud where ud.IUSNId=:IUSNId "
			+ "and ud.timePeriod_NId =:timePeriod_NId and ud.indicator_NId=:indicator "
			+ "and ud.unit_NId=:unit and ud.subgroup_Val_NId=:subgroup")
	public List<UtData> getData(@Param("IUSNId")int iusNid,
			@Param("timePeriod_NId")int timePeriodNid,@Param("indicator") int indicator, 
			@Param("unit")int unit, @Param("subgroup")int subgroup);
	
	@Override
	@Query(value="SELECT cast(t.TimePeriod as varchar) as TimePeriod,cast(a.Area_Name as varchar) as AreaName,"
			+ "cast(i.Indicator_Name as varchar(250)) as IndicatorName,cast(u.Unit_Name as varchar) as UnitName,"
			+ "cast(s.Subgroup_Val as varchar) as SubgroupVal,cast(sr.IC_Name as varchar) as ICName,"
			+ "ut.Data_Value FROM ut_data ut,ut_area_en a,ut_indicator_en i, ut_timeperiod t,"
			+ "ut_subgroup_vals_en s,ut_indicator_classifications_en sr,ut_unit_en u "
			+ "where a.Area_NId= ut.Area_NId and ut.Indicator_NId = i.Indicator_NId and "
			+ "ut.TimePeriod_NId = t.TimePeriod_NId and ut.Subgroup_Val_NId = s.Subgroup_Val_NId "
			+ "and ut.Source_NId = sr.IC_NId and ut.Unit_NId = u.Unit_NId and ut.TimePeriod_NId =:timeperiod",nativeQuery=true)
	public List<Object[]> getByTimePeriod(@Param("timeperiod") int timeperiod);

	
	@Override
	@Query("SELECT utData , utArea , utTimePeriod FROM UtAreaEn utArea,UtData utData, UtTimeperiod utTimePeriod "
			+ "WHERE utArea.area_NId = utData.area_NId AND "
			+ "utData.timePeriod_NId = utTimePeriod.timePeriod_NId AND "
			+ "utArea.area_NId in (:areaList) AND utData.timePeriod_NId = :timeperiodId AND utData.IUSNId in (:iusIds) "
			+ "ORDER BY utData.data_Value")
	public List<Object[]> findDataByTimePeriodAndArea(@Param("timeperiodId") Integer timeperiodId,@Param("areaList") List<Integer> areaList, @Param("iusIds") Integer[] iusIds);
	
	
	@Override
	@Query(value="SELECT t.TimePeriod_NId,cast(t.TimePeriod as varchar) as TimePeriod,cast(a.Area_Name as varchar) as AreaName, "
			+ "cast(i.Indicator_Name as varchar(250)) as IndicatorName,cast(u.Unit_Name as varchar) as UnitName, "
			+ "cast(s.Subgroup_Val as varchar) as SubgroupVal,cast(sr.IC_Name as varchar(500)) as ICName, "
			+ "ut.Data_Value FROM ut_data ut,ut_area_en a,ut_indicator_en i, ut_timeperiod t, "
			+ "ut_subgroup_vals_en s,ut_indicator_classifications_en sr,ut_unit_en u "
			+ "where a.Area_NId= ut.Area_NId and ut.Indicator_NId = i.Indicator_NId and "
			+ "ut.TimePeriod_NId = t.TimePeriod_NId and ut.Subgroup_Val_NId = s.Subgroup_Val_NId "
			+ "and ut.Source_NId = sr.IC_NId and ut.Unit_NId = u.Unit_NId and "
			+ "ut.Source_NId in (SELECT IC_NId "
			+ "FROM ut_indicator_classifications_en where IC_Parent_NId in (SELECT IC_NId "
			+ "FROM ut_indicator_classifications_en where IC_Name='DISE')) and s.Subgroup_Val_NId=6 "
			+ "and i.Short_Name ='District/Block' and a.Area_Name in (:areaName)",nativeQuery=true)
	public List<Object[]> getABRCCData(@Param("areaName") List<String> areaName);
}
