package org.sdrc.devinfo.repository;

import java.util.List;

import org.sdrc.devinfo.domain.UtSubgroupValsEn;
import org.springframework.dao.DataAccessException;

/**
 * 
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in)
 *
 */
public interface UtSubgroupValsEnRepository {

	
	public List<Object[]> fetchIndicatorAndUnitBySectorNId(Integer SectorNid) throws DataAccessException;
	
	public List<Object[]> fetchSubgroupByIndicatorAndUnit(Integer IndicatorNid,Integer UnitNId) throws DataAccessException;
	
	List<UtSubgroupValsEn> findAll();
}
