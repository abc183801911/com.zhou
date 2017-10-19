package com.neo.springBoot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.neo.springBoot.domain.SiteInfo;
import com.neo.springBoot.mapper.mybatis.SqlProvider;

@Mapper
public interface SiteInfoMapper {
	
	@Select("select * from itxxz_site limit 1")
	SiteInfo findFirstSiteInfo() throws Exception;
	
	@Select("select * from itxxz_site where id=#{id}")
	SiteInfo findSiteInfoById(@Param("id") int id) throws Exception;

	@Select("select * from itxxz_site")
	List<SiteInfo> findSiteInfoAll() throws Exception;
	
	@SelectProvider(method = "findSiteInfo", type = SqlProvider.class)
	List<SiteInfo> findSiteInfo(Map<String, Object> map);
	
	@Insert("insert into itxxz_site(id,name,remark,url)values(#{id},#{name},#{remark},#{url})")
	void insertSiteInfo(SiteInfo siteInfo);
	
	@Update("update itxxz_site set name = #{name},remark = #{remark},url = #{url} where id = #{id}")
	void updateSiteInfo(SiteInfo siteInfo);
	
	@Delete("delete from itxxz_site where id = #{id}")
	void deleteSiteInfoById(Long id);
}
