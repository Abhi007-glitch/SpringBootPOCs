package dependencyInjection;

import org.springframework.stereotype.Controller;

@Controller
public class CricketCoach implements Coach {

	@Override
	public String getCommand() {
		
		return "practice Good Length balls for next 6 Overs. ";
	}

}
