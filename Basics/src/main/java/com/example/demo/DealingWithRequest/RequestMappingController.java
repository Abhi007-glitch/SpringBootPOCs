package com.example.demo.DealingWithRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingController {
	
	//CASE 1 : Most basic General form 
	
	@RequestMapping(value="/ex/foos", method=RequestMethod.GET )
	public @ResponseBody String getFoosBySimplePath()
	{
		return " Response from foos!!";
	}
	
	

}
