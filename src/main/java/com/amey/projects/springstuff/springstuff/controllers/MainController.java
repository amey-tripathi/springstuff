package com.amey.projects.springstuff.springstuff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amey.projects.springstuff.springstuff.commonscryptotest.ApacheCommonsCryptoTest;
import com.amey.projects.springstuff.springstuff.commonscryptotest.ApacheCommonsDecryptTest;

@RestController
public class MainController {
	
	@Autowired
	private ApacheCommonsCryptoTest apacheCommonsCryptoTest;
	
	@Autowired
	ApacheCommonsDecryptTest apacheCommonsDecryptTest;
	
	@RequestMapping("/encrypt")
	public String Encrypted() throws Exception {
		return apacheCommonsDecryptTest.Decrypt(apacheCommonsCryptoTest.Encrypt("dude i'm not encrypted"));
		//return apacheCommonsCryptoTest.Encrypt("dude i'm not encrypted");
	}

}
