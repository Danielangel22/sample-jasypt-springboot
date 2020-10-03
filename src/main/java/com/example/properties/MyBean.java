package com.example.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Value("${variable.secret-var}")
	private String datoEncry;
	
	
	public void printVariable(){
		System.out.println("============================================");
		System.out.format("Dato encriptado: %s\n", datoEncry);
		System.out.println("============================================");
	}
}
