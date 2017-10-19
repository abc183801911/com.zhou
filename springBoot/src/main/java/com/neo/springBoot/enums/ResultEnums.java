package com.neo.springBoot.enums;

public enum ResultEnums {
	UNKONW_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	PRIMARY_SITE(100,"小序列站点"),
	MIDDEL_SITE(101,"中等序列站点"),
	;
	private Integer code;
	private String msg;
	
	private ResultEnums(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
