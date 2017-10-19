package com.neo.springBoot.exception;

import com.neo.springBoot.enums.ResultEnums;

public class SiteInfoException extends RuntimeException {
	private Integer code;
	
	public SiteInfoException(ResultEnums resultEnums) {
		super(resultEnums.getMsg());
		this.code = resultEnums.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
