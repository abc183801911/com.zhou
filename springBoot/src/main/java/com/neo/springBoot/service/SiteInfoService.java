package com.neo.springBoot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.springBoot.domain.SiteInfo;
import com.neo.springBoot.mapper.SiteInfoMapper;

@Service
public class SiteInfoService {
	
	@Autowired
	SiteInfoMapper siteInfoMapper;
	
	public SiteInfo findFirstSiteInfo() {
		return siteInfoMapper.findFirstSiteInfo();
	}

	public SiteInfo findSiteInfoById(int id) {
		return siteInfoMapper.findSiteInfoById(id);
	}

	public List<SiteInfo> findSiteInfo(SiteInfo siteInfo) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", siteInfo.getName());
		map.put("remark", siteInfo.getRemark());
		return siteInfoMapper.findSiteInfo(map);
	}

}
