package org.sdrc.childinfo.repository.springdatajpa;

import java.util.List;

import org.sdrc.childinfo.domain.AreaMapper;
import org.sdrc.childinfo.repository.AreaMapperRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface SpringDataAreaMapperRepository extends AreaMapperRepository,
Repository<AreaMapper, Integer>{
	
	@Override
	@Query("SELECT area from AreaMapper area WHERE area.parentCode = :areaCode ORDER BY area.childCode ASC")
	public	List<AreaMapper> findChildByParentCode(@Param("areaCode") String areaCode);
	
	@Override
	@Query("SELECT area from AreaMapper area WHERE area.childCode = :areaCode OR area.parentCode = :areaCode  ORDER BY area.childCode ASC")
	List<AreaMapper> getAreaNameAndItsChilds(@Param("areaCode")String areaCode);
	
	
	@Override
	@Query("SELECT area from AreaMapper area WHERE area.area_name = :areaName")
	List<AreaMapper> getAreaCodeByName(@Param("areaName")String areaName);
	
	@Override
	@Query("SELECT area from AreaMapper area WHERE area.childCode = :childCode")
	List<AreaMapper> getAreaByAreaCode(@Param("childCode")String childCode);
	
	@Override
	@Query("SELECT area from AreaMapper area WHERE area.area_name = :districtName and area.parentCode =:stateCode")
	List<AreaMapper> getAreaCodeByNameAndParentCode(@Param("stateCode")String state,@Param("districtName")String district);
}
