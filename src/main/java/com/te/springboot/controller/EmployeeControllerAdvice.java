package com.te.springboot.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springboot.bean.EmployeeResponse;
import com.te.springboot.exception.EmployeeExp;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	public EmployeeResponse name(EmployeeExp exception) {
		EmployeeResponse response=new EmployeeResponse();
		response.setStatusCode(404);
		response.setMsg(exception.getMessage());
		return response;
	}
}
