package org.sdrc.devinfo.repository;

import java.util.Date;
import java.util.List;

import org.sdrc.devinfo.domain.UtTimeperiod;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface UtTimeperiodRepository{
	
	UtTimeperiod getByStartDateAndEndDate(Date startDate, Date endDate);
	List<UtTimeperiod> findAll();
	@Transactional
	UtTimeperiod save(UtTimeperiod timeperiod);
	List<UtTimeperiod> getTimeperiodByLimit(Pageable pageable) throws DataAccessException;

	public List<UtTimeperiod> findBySource_Nid(Integer iusNid, Integer SourceNid) throws DataAccessException;
	
	Object findLatestTimePeriodNId(Integer iusNid, Integer[] areaNid) throws DataAccessException;
	/**
	 * @param startDate
	 * @param endDate
	 * @param string
	 * @return
	 */
	UtTimeperiod findByStartDateAndEndDateAndPeriodicity(Date startDate, Date endDate, String string);
	/**
	 * @param string
	 * @return
	 */
	List<UtTimeperiod> findByPeriodicity(String string);


}
