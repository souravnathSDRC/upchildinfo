package org.sdrc.devinfo.repository.springdatajpa;

import org.sdrc.devinfo.domain.UtSubgroupTypeEn;
import org.sdrc.devinfo.repository.UtSubgroupTypeEnRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 *
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in) on 20-Dec-2016 11:36:03 am
 */
public interface DevinfoUtSubgroupTypeEnRepository extends
		JpaRepository<UtSubgroupTypeEn, Integer>, UtSubgroupTypeEnRepository {

}
