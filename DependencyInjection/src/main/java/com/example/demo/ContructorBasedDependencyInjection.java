package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContructorBasedDependencyInjection {
   
	
	private Coach coachResponding;
	
	public ContructorBasedDependencyInjection( Coach theCoach) {
		// TODO Auto-generated constructor stub
		coachResponding=theCoach;
	}
	
	
	@GetMapping("/nextCommand")
	public String giveOrder()
	{
		return (coachResponding.getCommand());
	}
}
