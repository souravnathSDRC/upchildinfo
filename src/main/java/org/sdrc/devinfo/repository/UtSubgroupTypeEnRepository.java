package org.sdrc.devinfo.repository;

import java.util.List;

import org.sdrc.devinfo.domain.UtSubgroupTypeEn;

/**
 * 
 *
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in) on 20-Dec-2016 11:32:38 am
 */
public interface UtSubgroupTypeEnRepository {
	
	List<UtSubgroupTypeEn> findAll();
}
