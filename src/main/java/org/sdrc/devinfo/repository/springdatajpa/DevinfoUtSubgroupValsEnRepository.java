package org.sdrc.devinfo.repository.springdatajpa;

import java.util.List;

import org.sdrc.devinfo.domain.UtSubgroupValsEn;
import org.sdrc.devinfo.repository.UtSubgroupValsEnRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in)
 * @author Sourav nath 
 */
public interface DevinfoUtSubgroupValsEnRepository extends
		UtSubgroupValsEnRepository, Repository<UtSubgroupValsEn, Integer> {
	
	
	
	@Override
	@Query("SELECT  DISTINCT ius.unit_NId,ius.indicator_NId,ind.indicator_Name,unt.unit_Name FROM UtIndicatorUnitSubgroup ius,UtIndicatorEn ind,UtUnitEn unt WHERE"
	+"  ius.indicator_NId=ind.indicator_NId and ius.unit_NId= unt.unit_NId and"
	+" ius.IUSNId in (SELECT ic.IUSNId  FROM UtIcIus ic where ic.IC_NId=:SectorNId) ")
	public List<Object[]> fetchIndicatorAndUnitBySectorNId(@Param("SectorNId") Integer sectorNId) throws DataAccessException;

	@Override
	@Query("SELECT ius.IUSNId,ius.indicator_NId,ius.unit_NId,subg.subgroup_Val FROM UtIndicatorUnitSubgroup ius,UtSubgroupValsEn subg WHERE"
	+" ius.subgroup_Val_NId= subg.subgroup_Val_NId and"
	+" ius.indicator_NId=:IndicatorNId and ius.unit_NId=:UnitNId")
	public List<Object[]> fetchSubgroupByIndicatorAndUnit(@Param("IndicatorNId") Integer indicatorNId,@Param("UnitNId") Integer unitNId) throws DataAccessException;

}
