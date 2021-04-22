package com.te.springboot.controller;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {
	
	
	@GetMapping(path="/")
	public String firstHandlerMethod() {
		return "TechnoElevate";
	}
}
