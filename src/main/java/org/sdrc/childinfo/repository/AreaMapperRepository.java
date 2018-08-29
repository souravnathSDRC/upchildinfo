package org.sdrc.childinfo.repository;

import java.util.List;

import org.sdrc.childinfo.domain.AreaMapper;
import org.springframework.data.repository.query.Param;

public interface AreaMapperRepository {

	List<AreaMapper> findChildByParentCode(String areaId);

	List<AreaMapper> getAreaNameAndItsChilds(String areaCode);

	List<AreaMapper> getAreaCodeByName(String areaName);

	List<AreaMapper> getAreaCodeByNameAndParentCode(String state,String district);
	
	List<AreaMapper> getAreaByAreaCode(@Param("childCode")String childCode);
}
