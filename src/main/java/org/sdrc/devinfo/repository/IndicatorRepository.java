package org.sdrc.devinfo.repository;
import java.util.List;

import org.sdrc.devinfo.domain.UtIndicatorEn;
import org.springframework.dao.DataAccessException;

public interface IndicatorRepository
{
	public List<Object[]> getIUSNIdList(Integer sectorNid) throws DataAccessException;
	
	public List<Object []> getFilteredIUSFromUTDataList(Integer[] iusNid,Integer[] areaNids) throws DataAccessException;
	
	public List<Object []> findByIC_Type(String indicatorType) throws DataAccessException;
	
//	public List<Object []> findByIC_Type(Integer sectorNid,Integer[] iusFilteredNIds) throws DataAccessException;
	
	public UtIndicatorEn findByIndicator_NId(int indicator_NId);
	
	public UtIndicatorEn findUtDataByIndicator_NId(int indicator_NId);
	/**
	 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in)
	 * @return
	 */
	List<UtIndicatorEn> findAll();
}
