package org.sdrc.devinfo.repository.springdatajpa;

import java.util.List;

import org.sdrc.devinfo.domain.UtIndicatorEn;
import org.sdrc.devinfo.repository.IndicatorRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DevinfoIndicatorRepository extends IndicatorRepository , JpaRepository<UtIndicatorEn , Long> { 
	
	@Override
	@Query("SELECT uticius.IUSNId FROM UtIcIus uticius WHERE uticius.IC_NId=:sectorNid")
	public List<Object[]> getIUSNIdList(@Param("sectorNid") Integer sectorNid) throws DataAccessException;

//
	@Override
	@Query("SELECT distinct utData.IUSNId"+
			" FROM UtData utData " +
			" WHERE utData.IUSNId IN (:iusNid) AND utData.area_NId IN (:areaNid)")
	public List<Object []> getFilteredIUSFromUTDataList(@Param("iusNid") Integer[] iusNid,@Param("areaNid") Integer[] areaNid) throws DataAccessException;

//	
//	@Override
//	@Query("SELECT distinct uticius,"+
//			" (SELECT utUnit FROM UtUnitEn utUnit where utUnit.unit_NId = utius.unit_NId), " +
//			" (SELECT utIn from UtIndicatorEn utIn WHERE utIn.indicator_NId = utius.indicator_NId AND utIn.short_Name = :indicatorType), " +
//			" (SELECT subEn from UtSubgroupValsEn subEn WHERE subEn.subgroup_Val_NId = utius.subgroup_Val_NId)" +
//			" FROM UtIcIus uticius,UtIndicatorUnitSubgroup utius,UtIndicatorEn utIn" +
//			" WHERE utius.IUSNId = uticius.IUSNId AND utius.indicator_NId = utIn.indicator_NId AND utIn.short_Name = :indicatorType")
//	public List<Object []> findByIC_Type(@Param("indicatorType") String indicatorType) throws DataAccessException;
	@Override
	@Query(value="SELECT " + 
			"I.Indicator_NId," + 
			"cast(I.Indicator_Info as varchar(500)) as Indicator_Info," + 
			"IU.IC_NId," + 
			"IU.IUSNId," + 
			"(cast(I.Indicator_Name as varchar(250))+','+cast(SG.Subgroup_Val as varchar) +' ('+cast(U.Unit_Name as varchar)+')') as 'IUSName' from " + 
			"ut_unit_en U," + 
			"ut_indicator_en I," + 
			"ut_subgroup_vals_en SG, " + 
			"ut_ic_ius IU," + 
			"ut_indicator_unit_subgroup IUS " + 
			"WHERE IUS.IUSNId=IU.IUSNId AND " + 
			"IUS.Indicator_NId = I.Indicator_NId AND " + 
			"IUS.Unit_NId = U.Unit_NId AND " + 
			"IUS.Subgroup_Val_NId = SG.Subgroup_Val_NId AND I.Short_Name =:indicatorType",nativeQuery=true)
	public List<Object []> findByIC_Type(@Param("indicatorType") String indicatorType) throws DataAccessException;

//	@Override
//	@Query("SELECT distinct uticius,(SELECT utUnit FROM UtUnitEn utUnit where utUnit.unit_NId = utius.unit_NId), " +
//			" (SELECT utIn from UtIndicatorEn utIn WHERE utIn.indicator_NId = utius.indicator_NId), " +
//			" (SELECT subEn from UtSubgroupValsEn subEn WHERE subEn.subgroup_Val_NId = utius.subgroup_Val_NId)" +
//			" FROM UtIcIus uticius,UtIndicatorUnitSubgroup utius,UtIndicatorEn utIn" +
//			" WHERE utius.IUSNId = uticius.IUSNId AND uticius.IUSNId IN (:iusFilteredNIds) AND uticius.IC_NId = :sectorNid Order by uticius.IUSNId ")
//	public List<Object []> findByIC_Type(@Param("sectorNid") Integer sectorNid,@Param("iusFilteredNIds") Integer[] iusFilteredNIds) throws DataAccessException;
	
	@Override
	@Query("SELECT  utIndicatorEn FROM UtData utData, UtIndicatorEn utIndicatorEn"
			+ " WHERE utData.indicator_NId = utIndicatorEn.indicator_NId AND "
			+ " utData.IUSNId = :iusNID " )
	public UtIndicatorEn findByIndicator_NId(@Param("iusNID")int indicator_NId);
	
	@Override
	@Query("SELECT  utIndicatorEn FROM UtData utData, UtIndicatorEn utIndicatorEn"
			+ " WHERE utData.indicator_NId = utIndicatorEn.indicator_NId AND "
			+ " utData.indicator_NId = :indicator_NId " )
	public UtIndicatorEn findUtDataByIndicator_NId(@Param("indicator_NId")int indicator_NId);
}