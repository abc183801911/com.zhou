package com.neo.springBoot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.neo.springBoot.domain.SiteInfo;
import com.neo.springBoot.mapper.mybatis.SqlProvider;

@Mapper
public interface SiteInfoMapper {
	
	@Select("select * from itxxz_site limit 1")
	SiteInfo findFirstSiteInfo();
	
	@Select("select * from itxxz_site where id=#{id}")
	SiteInfo findSiteInfoById(@Param("id") int id);

	@SelectProvider(method = "findSiteInfo", type = SqlProvider.class)
	List<SiteInfo> findSiteInfo(Map<String, Object> map);
	
}
