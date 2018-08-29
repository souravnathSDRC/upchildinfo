package org.sdrc.childinfo.repository;

import java.util.List;

import org.sdrc.childinfo.domain.UUIdGenerator;
import org.springframework.transaction.annotation.Transactional;

public interface UUIdGeneratorRepository {

	@Transactional
	void save(UUIdGenerator uuidGenerator);

	List<UUIdGenerator> findAll();

}
