package org.sdrc.childinfo.repository.springdatajpa;

import org.sdrc.childinfo.domain.SamikshyaUser;
import org.sdrc.childinfo.repository.UserRepository;
import org.springframework.data.repository.Repository;

public interface SpringDataUserRepository extends UserRepository, Repository<SamikshyaUser, Integer> {
	
}
