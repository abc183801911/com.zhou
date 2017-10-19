package com.neo.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neo.springBoot.domain.Result;
import com.neo.springBoot.domain.SiteInfo;
import com.neo.springBoot.service.SiteInfoService;
import com.neo.springBoot.utils.ResultUtil;

@RestController
public class SiteInfoController {
	private final static Logger logger = LoggerFactory.getLogger(SiteInfoController.class);
	
	@Autowired
	SiteInfoService siteInfoService;
	
	@RequestMapping("/findFirstSiteInfo")
	public ModelAndView findFirstSiteInfo() throws Exception{
		
		SiteInfo siteInfo = siteInfoService.findFirstSiteInfo();
		Result<SiteInfo> siteResult = ResultUtil.success(siteInfo);		
		logger.info(siteResult.toString());
		
		ModelAndView modelAndView = new ModelAndView("findSiteInfo");
		modelAndView.addObject("siteResultList", siteResult);
		
		return modelAndView;
		
	}
	
	@RequestMapping("/findSiteInfoById")
	public ModelAndView findSiteInfoById(@RequestParam(value="id",required=false,defaultValue="0") int id) throws Exception {
		
		SiteInfo siteInfo = siteInfoService.findSiteInfoById(id);
		Result<SiteInfo> siteResult = ResultUtil.success(siteInfo);	
		
		ModelAndView modelAndView = new ModelAndView("findSiteInfo");
		modelAndView.addObject("siteResultList", siteResult);
		
		return modelAndView;
	}
	
	@RequestMapping("/findSiteInfoAll")
	public ModelAndView findSiteInfoAll() throws Exception {
		List<SiteInfo> siteInfoList= siteInfoService.findSiteInfoAll();
		List<Result<SiteInfo>> siteResultList = new ArrayList<>();
		for(SiteInfo siteInfo : siteInfoList) {
			Result<SiteInfo> siteResult = ResultUtil.success(siteInfo);	
			siteResultList.add(siteResult);
			logger.info("-----------查询siteInfoAll的信息-----------");
			logger.info(siteInfo.toString());	
		}		
		
		ModelAndView modelAndView = new ModelAndView("findSiteInfo");
		modelAndView.addObject("siteResultList", siteResultList);
		
		return modelAndView;
	}
	
	@RequestMapping({"/findSiteInfo","/hhaa"})
	public ModelAndView findSiteInfo(SiteInfo siteInfo) {
		siteInfo.setName("项目");
		siteInfo.setRemark("项目");
		
		List<SiteInfo> siteInfoList = siteInfoService.findSiteInfo(siteInfo);
		List<Result<SiteInfo>> siteResultList = new ArrayList<>();
		
		for(SiteInfo site : siteInfoList) {
			Result<SiteInfo> siteResult = ResultUtil.success(site);	
			siteResultList.add(siteResult);
			logger.info("-----------查询siteInfo的信息-----------");
			logger.info(siteInfo.toString());				
		}		
		
		ModelAndView modelAndView = new ModelAndView("findSiteInfo");
		modelAndView.addObject("siteResultList", siteResultList);
		
		return modelAndView;
	}
	
	@RequestMapping({"/insertSiteInfo"})
	public Result insertSiteInfo(@Valid SiteInfo siteInfo,BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		
		siteInfoService.insertSiteInfo(siteInfo);
		
		return ResultUtil.success(siteInfo);
	}
	
	@RequestMapping({"/updateSiteInfo"})
	public ModelAndView updateSiteInfo(SiteInfo siteInfo) {
		
		siteInfoService.updateSiteInfo(siteInfo);
		ModelAndView modelAndView = new ModelAndView("redirect:findSiteInfoAll");
		return modelAndView;
	}	
						
	@RequestMapping("/deleteSiteInfoById")
	public ModelAndView deleteSiteInfoById(Long id) {
		
		siteInfoService.deleteSiteInfoById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:findSiteInfoAll");
		return modelAndView;
	}
	
	
	@RequestMapping("/toInsertSiteInfo")
	public ModelAndView toInsertSiteInfo() {
		
		ModelAndView modelAndView = new ModelAndView("insertSiteInfo");
		
		return modelAndView;
	}
	
	@RequestMapping("/toUpdateSiteInfo")
	public ModelAndView toUpdateSiteInfo(int id) throws Exception {
		
		SiteInfo siteInfo = siteInfoService.findSiteInfoById(id);
		
		ModelAndView modelAndView = new ModelAndView("updateSiteInfo");
		modelAndView.addObject("siteInfo",siteInfo);
		
		return modelAndView;
	}	
	
	
}
