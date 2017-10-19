package com.neo.springBoot.domain;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class SiteInfo {
	@Min(value=12,message="最小不能小于12")
	private int id;
	@NotBlank(message="不能为空")
	private String name;
	private String remark;
	private String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "SiteInfo [id=" + id + ", name=" + name + ", remark=" + remark + ", url=" + url + "]";
	}
	
	
}
