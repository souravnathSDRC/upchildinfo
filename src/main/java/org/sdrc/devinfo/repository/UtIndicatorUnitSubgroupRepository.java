package org.sdrc.devinfo.repository;

import java.util.List;

import org.sdrc.devinfo.domain.UtIndicatorUnitSubgroup;
import org.springframework.dao.DataAccessException;

public interface UtIndicatorUnitSubgroupRepository {
	
	UtIndicatorUnitSubgroup findByIUSNId(int IUSNId) throws DataAccessException;
	
	UtIndicatorUnitSubgroup findByIUSNIdAndUnitNid(int IUSNId,int unitNid) throws DataAccessException;
	
	UtIndicatorUnitSubgroup findByIndicatorNIdAndSubgroupNidAndUnitNid(int indicatorNid,int subgroupNid,int unitNid) throws DataAccessException;
	
	List<UtIndicatorUnitSubgroup> findByUnitNid(int unitNid) throws DataAccessException;
	
	/**
	 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in)
	 * @return
	 */
	List<UtIndicatorUnitSubgroup> findAll();

	List<Object[]> getIUS(int id);
}
