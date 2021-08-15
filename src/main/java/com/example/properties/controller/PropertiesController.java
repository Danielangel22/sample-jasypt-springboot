package com.example.properties.controller;

import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Value("${secret.env}")
	private String envEcripted;
	
	@Autowired
	private StringEncryptor stringEncryptor;

	@GetMapping
	public String getEncryptedData() {
		return this.envEcripted;
	}

	@GetMapping(value = "/compare")
	public String compareEncriptedEnv(@RequestParam String rawEnv) {
		String env = "ENC(" + stringEncryptor.encrypt(rawEnv) + ")";
		log.info("Values encript: new [ {} ] : old [ {} ]", env, this.envEcripted);
		return stringEncryptor.decrypt(envEcripted.substring("ENC@".length()));
	}

}
