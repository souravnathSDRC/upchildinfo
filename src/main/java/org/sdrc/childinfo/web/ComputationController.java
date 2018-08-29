package org.sdrc.childinfo.web;

import java.util.ArrayList;
import java.util.List;

import org.sdrc.childinfo.model.IUSValueObject;
import org.sdrc.childinfo.model.UtDataCollection;
import org.sdrc.childinfo.service.ComputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class ComputationController {
	private final ComputationService computationService;

	
	@Autowired
	public ComputationController(ComputationService computationService) {
		this.computationService = computationService;
	}
	


	
	@RequestMapping(value = { "/api/getindicatorandunitbysectornid" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<Object[]> fetchIndicatorAndUnitBySectorNId(
			@RequestParam(required = false) String sectorNId) throws Exception {
		List<Object[]> listofSubgroups=new ArrayList<Object[]>();
		if (sectorNId != null ){
			listofSubgroups = computationService.fetchIndicatorAndUnitBySectorNId(sectorNId);
		}
		return listofSubgroups;
	}
	
	@RequestMapping(value = { "/api/getsubgroupbyindicatorandunit" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<Object[]> fetchSubgroupByIndicatorAndUnit(
			@RequestParam(required = false) Integer indicatorNId,
			@RequestParam(required = false) Integer unitNId) throws Exception {
		List<Object[]> listofSubgroups=new ArrayList<Object[]>();
		if (indicatorNId != null && unitNId!=null){
			listofSubgroups = computationService.fetchSubgroupByIndicatorAndUnit(indicatorNId,unitNId);
		}
		return listofSubgroups;
	}
	
	
	@RequestMapping(value="/api/compositeIndexdata",method=RequestMethod.GET)
	@ResponseBody
	public UtDataCollection fetchBurdenData(
			@RequestParam(required = false) String iusObject,
			@RequestParam(required = false) String areaId,
			@RequestParam(required = false) Integer childLevel) throws Exception {
	
		ObjectMapper mapper = new ObjectMapper();
		IUSValueObject[] dataModelList = mapper.readValue(iusObject, IUSValueObject[].class);
		List<IUSValueObject> iusDataModelList= new ArrayList<IUSValueObject>();
		iusDataModelList=java.util.Arrays.asList(dataModelList);
		
		UtDataCollection valList = new UtDataCollection();
		System.out.println("Checking the parameter values for UT DATA ====>   ==  " + areaId + "  ==  "  + childLevel);
		if (iusDataModelList != null) {
			valList = computationService
					.fetchCompositeIndexData(iusDataModelList,areaId,childLevel);
		}

		return valList;
		
	}
}
