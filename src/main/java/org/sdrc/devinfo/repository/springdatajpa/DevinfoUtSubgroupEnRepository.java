package org.sdrc.devinfo.repository.springdatajpa;

import org.sdrc.devinfo.domain.UtSubgroupEn;
import org.sdrc.devinfo.repository.UtSubgroupEnRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevinfoUtSubgroupEnRepository extends UtSubgroupEnRepository,
		JpaRepository<UtSubgroupEn, Integer> {

}
