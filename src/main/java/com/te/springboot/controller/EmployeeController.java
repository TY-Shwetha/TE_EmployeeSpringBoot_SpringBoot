package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.EmployeeBean;
import com.te.springboot.bean.EmployeeResponse;
import com.te.springboot.service.EmployeeService;



@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping(path="/getemp",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getEmp(Integer id) {
		EmployeeResponse response=new EmployeeResponse();
		EmployeeBean bean =service.getEmployee(id);
		if (bean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data found"+id);
			response.setBean(bean);
		}else {
			response.setStatusCode(400);
			response.setMsg("Error");
			response.setDescription("Data not found"+id);
			
		}
		return response;
	}
	
	
	@GetMapping(path="/getAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getAll() {
		EmployeeResponse response=new EmployeeResponse();
		List<EmployeeBean> list=service.getAllEmp();
		if (list != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data found");
			response.setEmployeeBean(list);
		}else {
			response.setStatusCode(400);
			response.setMsg("Error");
			response.setDescription("Data not found");
		}	
		return response;
	}
	
	
	@PostMapping(path="/add",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse addEmployee(@RequestBody EmployeeBean bean) {
		EmployeeResponse response=new EmployeeResponse();	
		if (service.addEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Added details Successfully");
		}else {
			response.setStatusCode(400);
			response.setMsg("Error");
			response.setDescription("Could not Add");
		}	
		return response;
	}
	
	
	@DeleteMapping(path="/delete/{emp_id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse deleteEmp(@PathVariable(name = "emp_id") int id ) {
		EmployeeResponse response=new EmployeeResponse();	
		if (service.deleteEmpData(id)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data deleted successfully : "+id);
		}else {
			response.setStatusCode(400);
			response.setMsg("Error");
			response.setDescription("Could not delete : "+id);
		}	
		return response;
	}
	
	@PutMapping(path="update",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse updateemp(@RequestBody  EmployeeBean bean) {
		EmployeeResponse response=new EmployeeResponse();	
		if (service.updateEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data updated successfully");
		}else {
			response.setStatusCode(400);
			response.setMsg("Error");
			response.setDescription("Could not update");
		}	
		return response;

	}
}


