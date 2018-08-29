package org.sdrc.devinfo.repository;

import java.util.List;

import org.sdrc.devinfo.domain.UtIndicatorClassificationsEn;

/**
 * 
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in)
 *
 */
public interface UtIndicatorClassificationsEnRepository {
	
	List<UtIndicatorClassificationsEn> findAll();

	List<UtIndicatorClassificationsEn> getSubsector();

	int getSubsectorId(String subSectorName);
}
