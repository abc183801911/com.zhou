package com.neo.springBoot.mapper.mybatis;

import java.util.Map;

public class SqlProvider {
	
	public String findSiteInfo(Map<String, Object> map) {
		final String name = (String)map.get("name");
		final String remark = (String)map.get("remark");
		
		StringBuffer sb= new StringBuffer();
		sb.append("select id,name,remark,url from itxxz_site");
		sb.append(" where 1=1");
		if(name != null && name.length()>0) {
			sb.append(" and name LIKE '%" + name + "%'");
		}
		if(remark != null && remark.length()>0) {
			sb.append(" or remark LIKE '%" + remark + "%'");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
