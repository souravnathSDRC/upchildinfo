package org.sdrc.devinfo.repository.springdatajpa;

import org.sdrc.devinfo.domain.UtUnitEn;
import org.sdrc.devinfo.repository.UtUnitEnRepository;
import org.springframework.data.repository.Repository;

/**
 * 
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in)
 *
 */
public interface DevinfoUtUnitEnRepository extends UtUnitEnRepository,
		Repository<UtUnitEn, Integer> {

}
