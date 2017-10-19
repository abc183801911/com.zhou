package com.neo.springBoot.handle;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neo.springBoot.domain.Result;
import com.neo.springBoot.exception.SiteInfoException;
import com.neo.springBoot.utils.ResultUtil;

@RestControllerAdvice
public class ExceptionHandle {
	@ExceptionHandler(value=Exception.class)
	public Result handle(Exception e) {
		if(e instanceof SiteInfoException) {
			SiteInfoException siteInfoException = (SiteInfoException)e;
			return ResultUtil.error(siteInfoException.getCode(), siteInfoException.getMessage());
		}else {
			return ResultUtil.error(-1, e.getMessage());
		}
		
	}
}
