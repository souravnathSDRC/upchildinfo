package org.sdrc.childinfo.repository;

import javax.transaction.Transactional;

import org.sdrc.childinfo.domain.CounterCount;

public interface CounterCountRepository {
	@Transactional
	void save(CounterCount counterCount);

	CounterCount findTotalCount();
	
}
