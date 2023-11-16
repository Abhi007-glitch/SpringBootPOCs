package com.example.demo.DealingWithResponseBody;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import utils.CustomResponseBody; 
import utils.LoginForm;

// *************** ResponseBody convert's our java object to a respective json/or any other formate mentioned in the request and response type mentioned in the RequestMapping Annotation
//************** Serving API with plane @Controller and @RequestMapping instead of using @RestController


@Controller  
@RequestMapping
public class ResponseBodyPOCs {
	
	
	@PostMapping("/events")
	public @ResponseBody CustomResponseBody nodeResponseController(@RequestBody String eventType)
	{
	System.out.println(eventType);
	return new CustomResponseBody(eventType+ " :  received successfully!!");
	}
	
	
	@GetMapping("/events")
	public @ResponseBody CustomResponseBody eventRouteTest()
	{
	return new CustomResponseBody("Event Route Up and running");
	}
	
	
	//CASE 1: BASIC structure
	@PostMapping("/voteOfThanks/{pVar}")
    public @ResponseBody CustomResponseBody postResponseController(@RequestBody LoginForm loginFormInput, @RequestParam String rParam, @PathVariable String pVar)
    {
    	 
		return new CustomResponseBody("Thanks "+loginFormInput.getName()+ "  for joining "+rParam+ " organised by "+pVar);
    }
	
	
	//CASE 2: Mapping as per response Type mentioned in the request header 
	
	@PostMapping(value="/problemStatement/{teamId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomResponseBody postContentJSONType(@RequestBody LoginForm loginFormInput , @RequestParam String teamName, @PathVariable String teamId)
	{
		String response="";
		int id = Integer.parseInt(teamId);
		if (id%2==0)
		{
			response="1 : Create a blockChain based solution for securing transaction for a farmer's bank and build a cross platform solution for interacting.";
		}
		else
		{
			response="2 : Provide some soltion to generate PPT and notes from the Live lecture video of faculty. Output should be generated within 15-20 min of lecture completion. ";
		}
		
		return new CustomResponseBody("Hi team "+teamName+ ", your problem statement is  statement "+response +" Good Luck and perform well for next 36 hrs");
	}
	
	
	@PostMapping(value="/problemStatement/{teamId}", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody CustomResponseBody postContentXMLType( @RequestParam String teamName, @PathVariable String teamId)
	{
		return new CustomResponseBody("Custome Body response for XML type content request !!");
	}
	
	

}


