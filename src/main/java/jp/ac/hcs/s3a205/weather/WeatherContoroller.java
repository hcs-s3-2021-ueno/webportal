package jp.ac.hcs.s3a205.weather;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherContoroller {
	
	@Autowired
	private WeatherService weatherService;
	
	@PostMapping("/weather")
	public String postWeather(Principal principal, Model model) {
		
		WeatherEntity weatherEntity = weatherService.getWethaer();
		model.addAttribute("weatherEntity", weatherEntity);
		
	}
}
