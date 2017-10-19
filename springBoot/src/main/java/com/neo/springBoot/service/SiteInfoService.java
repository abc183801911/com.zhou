package com.neo.springBoot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.springBoot.controller.SiteInfoController;
import com.neo.springBoot.domain.SiteInfo;
import com.neo.springBoot.enums.ResultEnums;
import com.neo.springBoot.exception.SiteInfoException;
import com.neo.springBoot.mapper.SiteInfoMapper;

@Service
public class SiteInfoService {
	private final static Logger logger = LoggerFactory.getLogger(SiteInfoController.class);
	
	@Autowired
	SiteInfoMapper siteInfoMapper;
	
	public SiteInfo findFirstSiteInfo() throws Exception{
		try {
			return siteInfoMapper.findFirstSiteInfo();
		} catch (Exception e) {
			logger.error("com.neo.springBoot.service.SiteInfoService.findFirstSiteInfo", e);
			throw new SiteInfoException(ResultEnums.UNKONW_ERROR);
		}

	}

	public SiteInfo findSiteInfoById(int id) throws Exception {
		
//		if(id <10) {
//			throw new SiteInfoException(ResultEnums.PRIMARY_SITE);
//		}else if(id >=10 && id <20) {
//			throw new SiteInfoException(ResultEnums.MIDDEL_SITE);
//		}
		
		try {
			return siteInfoMapper.findSiteInfoById(id);
		} catch (Exception e) {
			logger.error("com.neo.springBoot.service.SiteInfoService.findSiteInfoById", e);
			throw new SiteInfoException(ResultEnums.UNKONW_ERROR);
		}
	}

	public List<SiteInfo> findSiteInfoAll() throws Exception {
		try {
			return siteInfoMapper.findSiteInfoAll();
		} catch (Exception e) {
			logger.error("com.neo.springBoot.service.SiteInfoService.findSiteInfoAll", e);
			throw new SiteInfoException(ResultEnums.UNKONW_ERROR);
		}
	}
	
	public List<SiteInfo> findSiteInfo(SiteInfo siteInfo) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", siteInfo.getName());
		map.put("remark", siteInfo.getRemark());
		return siteInfoMapper.findSiteInfo(map);
	}

	public void insertSiteInfo(SiteInfo siteInfo) {
		siteInfoMapper.insertSiteInfo(siteInfo);
	}
	
	public void updateSiteInfo(SiteInfo siteInfo) {
		siteInfoMapper.updateSiteInfo(siteInfo);
	}
	
	public void deleteSiteInfoById(Long id) {
		siteInfoMapper.deleteSiteInfoById(id);
	}
	
}
