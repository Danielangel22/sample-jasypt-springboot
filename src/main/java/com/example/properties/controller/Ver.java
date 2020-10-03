package com.example.properties.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ver {
	
	@Value("${variable.secret-var}")
	private String datoEncry;
	
	@GetMapping
	public String ver() {
		return datoEncry;
	}

}
