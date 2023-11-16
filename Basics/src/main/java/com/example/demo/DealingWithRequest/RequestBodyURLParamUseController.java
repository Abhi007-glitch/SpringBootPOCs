package com.example.demo.DealingWithRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import utils.LoginForm;



@RestController
public class RequestBodyURLParamUseController {
	
	@GetMapping("/")
	public String homePage()
	{
		return "Up and running!!";
	}
	
	// RequestBody's LoginForm should perfectly match the structure of LoginForm classs 
	@PostMapping("/loginForm")
	public ResponseEntity postController(@RequestBody LoginForm loginFormDetails)
	{
		if (loginFormDetails.getName().equals("abhinav") && loginFormDetails.getPassword().equals("abhinav@123"))
		{
			return ResponseEntity.ok(HttpStatus.OK);
		}
		
		return ResponseEntity.ok(HttpStatus.UNAUTHORIZED);
	}
	
	
	
  
}
