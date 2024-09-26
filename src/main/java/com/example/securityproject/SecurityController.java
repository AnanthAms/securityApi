package com.example.securityproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping(value="/getStudent")
	public String get() {
		return "this is a student";
	}
	
	@GetMapping(value="/getTeacher")
	public String gets() {
		return "this is a teacher";
	}
	
	@GetMapping(value="/getManager")
	public String getthem() {
		return "this is a manager";
	}
}
