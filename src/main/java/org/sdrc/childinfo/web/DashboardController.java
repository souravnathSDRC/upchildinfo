package org.sdrc.childinfo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sdrc.childinfo.model.LineSeries;
import org.sdrc.childinfo.model.UtDataCollection;
import org.sdrc.childinfo.model.ValueObject;
import org.sdrc.childinfo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {

	private final DashboardService dashboardService;

	@Autowired
	public DashboardController(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@RequestMapping(value = { "/indicators" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<ValueObject> getIndicators(
			@RequestParam(required = false) String indicatorType) throws Exception {
		List<ValueObject> valueObjects = new ArrayList<>();
		if (indicatorType != null ){
			valueObjects = dashboardService.fetchIndicators(indicatorType);
			
		}
		return valueObjects;
	}
	@RequestMapping(value = { "/sectors" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<ValueObject> fetchAllSectors(@RequestParam(required = false) String indicatorType) throws Exception {
		System.out.println("Sectors---------");
		return dashboardService.fetchAllSectors(indicatorType);
	}
	
//	@RequestMapping(value = { "/api/indicators" }, method = { RequestMethod.GET })
//	@ResponseBody
//	public List<ValueObject> fetchIndicators(
//			@RequestParam(required = false) String sector,
//			@RequestParam(required = false) String parentAreaCode,
//			@RequestParam(required = false) Integer level) throws Exception {
//		List<ValueObject> valueObjects = new ArrayList<>();
//		if (sector != null ){
//			valueObjects = dashboardService.fetchIndicators(sector,parentAreaCode,level);
//			
//		}
//		return valueObjects;
//	}
	
	@RequestMapping(value = { "/sources" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<ValueObject> fetchSources(
			@RequestParam(required = false) String iusnid) throws Exception {
		List<ValueObject> valueObjects = new ArrayList<>();
		if (iusnid != null ){
			valueObjects = dashboardService.fetchSources(iusnid);
		}
		return valueObjects;
	}
	
	@RequestMapping(value = { "/getsourcesbylevel" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<ValueObject> fetchSourcesByLevel(
			@RequestParam(required = false) String iusnid,
			@RequestParam(required = false) Integer childLevel) throws Exception {
		List<ValueObject> valueObjects = new ArrayList<>();
		if (iusnid != null ){
			valueObjects = dashboardService.fetchSourcesByLevel(iusnid,childLevel);
		}
		return valueObjects;
	}


	@RequestMapping(value = { "/timeperiod" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<ValueObject> fetchUtTimeperiod(
			@RequestParam(required = false) String iusnid, @RequestParam(required = false) String sourceNid) throws Exception {
		
		List<ValueObject> valueObjects = new ArrayList<>();
		if (iusnid != null && sourceNid != null ){
//			valueObjects = new ArrayList<>();
			valueObjects = dashboardService.fetchUtTimeperiod(Integer.parseInt(iusnid),Integer.parseInt(sourceNid));
		}
		return valueObjects;
	}

//	@RequestMapping(value = { "/api/sectors" }, method = { RequestMethod.GET })
//	@ResponseBody
//	public List<ValueObject> fetchAllSectors() throws Exception {
//		System.out.println("Sectors---------");
//		return dashboardService.fetchAllSectors("SC");
//	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public UtDataCollection fetchData(
			@RequestParam(required = false) String indicatorId,
			@RequestParam(required = false) String sourceNid,
			@RequestParam(required = false) String areaId,
			@RequestParam(required = false) String timeperiodId,
			@RequestParam(required = false) Integer childLevel) throws Exception {
		  
		UtDataCollection valList = new UtDataCollection();
		System.out.println("Checking the parameter values for UT DATA ====> "+ indicatorId + "  ==  "+ sourceNid + "  ==  " + areaId + "  ==  " + timeperiodId+ "  ==  " + childLevel);
		if (indicatorId != null && sourceNid !=null && timeperiodId != null) {
			valList = dashboardService
					.fetchData(indicatorId,sourceNid, areaId, timeperiodId,childLevel);
		}

		return valList;
	}
	@RequestMapping(value = "/computedata", method = RequestMethod.GET)
	@ResponseBody
	public UtDataCollection fetchComputeData(
			@RequestParam(required = false) String indicatorId,
			@RequestParam(required = false) String areaId,
			@RequestParam(required = false) String timeperiodId,
			@RequestParam(required = false) Integer childLevel,
			@RequestParam(required = false) Integer sourceNId) throws Exception {
		  
		UtDataCollection valList = new UtDataCollection();
		System.out.println("Checking the parameter values for UT DATA ====> "+ indicatorId + "  ==  " + areaId + "  ==  " + timeperiodId+ "  ==  " + childLevel);
		if (indicatorId != null  && timeperiodId != null) {
			valList = dashboardService
					.fetchComputeData(indicatorId,areaId, timeperiodId,childLevel,sourceNId);
		}

		return valList;
	}
	
	@RequestMapping(value="/burdendata",method=RequestMethod.GET)
	@ResponseBody
	public UtDataCollection fetchBurdenData(
			@RequestParam(required = false) Integer iusNIdForProjection,
			@RequestParam(required = false) Integer iusNId,
			@RequestParam(required = false) Integer iusNIdForIMRorU5MR,
			@RequestParam(required = false) String areaId,
			@RequestParam(required = false) String timeperiodId,
			@RequestParam(required = false) Integer childLevel,
			@RequestParam(required = false) Integer sourceNIdForProjection,
			@RequestParam(required = false) Integer sourceNId,
			@RequestParam(required = false) Integer sourceNIdForIMRorU5MR) throws Exception {
		UtDataCollection valList = new UtDataCollection();
		System.out.println("Checking the parameter values for UT DATA ====> "+ iusNIdForProjection + "  ==  " + areaId + "  ==  " + timeperiodId+ "  ==  " + childLevel);
		if (iusNIdForProjection != null  && timeperiodId != null) {
			valList = dashboardService
					.fetchBurdenData(iusNIdForProjection,iusNId,iusNIdForIMRorU5MR,areaId, timeperiodId,childLevel,sourceNIdForProjection,sourceNId,sourceNIdForIMRorU5MR);
		}

		return valList;
		
	}
	
	@RequestMapping(value = "/lineData", method = RequestMethod.GET)
	@ResponseBody
	public List<List<LineSeries>> fetchLineData(
			@RequestParam(required = false) Integer iusNid,
			@RequestParam(required = false) Integer areaNid) throws Exception {
				return dashboardService.fetchChartData(iusNid, areaNid);
			}
	
	@RequestMapping(value = "/ColData", method = RequestMethod.GET)
	@ResponseBody
	public List<List<Map<Object, String>>> fetchColData(
			@RequestParam(required = false) Integer iusNid,
			@RequestParam(required = false) Integer areaNid) throws Exception {
				return dashboardService.fetchColChartData(iusNid, areaNid);
			}
	
	@RequestMapping(value = {"/"}, method = {RequestMethod.GET})
	public String getCounter(Model model){
		model.addAttribute("noOfCounter", dashboardService.getCounter().getNoOfCounter());
		
		return "welcome";
	}
	@RequestMapping(value = {"/getCounterJson"}, method = {RequestMethod.GET})
	@ResponseBody
	public String getCounterJson(Model model){
		//model.addAttribute("noOfCounter", dashboardService.getCounter().getNoOfCounter());
		
		return dashboardService.fetchCounter().getNoOfCounter().toString();
	}
}