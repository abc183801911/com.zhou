package com.neo.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neo.springBoot.domain.SiteInfo;
import com.neo.springBoot.service.SiteInfoService;

@RestController
public class SiteInfoController {
	
	@Autowired
	SiteInfoService siteInfoService;
	
	@RequestMapping("/findFirstSiteInfo")
	public String findFirstSiteInfo() {
		SiteInfo siteInfo = siteInfoService.findFirstSiteInfo();
		
		System.out.println("Id: " + siteInfo.getId());
		System.out.println("Name: " + siteInfo.getName());
		System.out.println("Remark: " + siteInfo.getRemark());
		System.out.println("Url: " + siteInfo.getUrl());
		return "IT学习者-螃蟹";
		
	}
	
	@RequestMapping("/findSiteInfoById")
	public String findSiteInfoById(int id) {
		
		SiteInfo siteInfo = siteInfoService.findSiteInfoById(id);
		
		System.out.println("-----------查询id为x的信息-----------");
		System.out.println("Id: " + siteInfo.getId());
		System.out.println("Name: " + siteInfo.getName());
		System.out.println("Remark: " + siteInfo.getRemark());
		System.out.println("Url: " + siteInfo.getUrl());
		return "IT学习者-螃蟹";
	}
	
	@RequestMapping("/findSiteInfo")
	public ModelAndView findSiteInfo(SiteInfo siteInfo) {
		siteInfo.setName("项目");
		siteInfo.setRemark("项目");
		
		List<SiteInfo> siteInfoList = siteInfoService.findSiteInfo(siteInfo);
		
		for(SiteInfo site : siteInfoList) {
			System.out.println("-----------查询siteInfo的信息-----------");
			System.out.println("Id: " + site.getId());
			System.out.println("Name: " + site.getName());
			System.out.println("Remark: " + site.getRemark());
			System.out.println("Url: " + site.getUrl());			
		}		
		
		ModelAndView modelAndView = new ModelAndView("findSiteInfo");
		modelAndView.addObject("siteInfoList", siteInfoList);
		
		return modelAndView;
	}
}
