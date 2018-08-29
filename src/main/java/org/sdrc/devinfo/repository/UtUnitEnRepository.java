package org.sdrc.devinfo.repository;

import java.util.List;

import org.sdrc.devinfo.domain.UtUnitEn;

/**
 * 
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in)
 *
 */
public interface UtUnitEnRepository {
	
	List<UtUnitEn> findAll();
}
