package com.src.rest.controller;


import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.src.rest.constants.Constants;
import com.src.rest.entity.Forecast;
import com.src.rest.service.WeatherService;

@EnableWebMvc
@RestController
@RequestMapping(value = Constants.FORECAST)

public class WeatherController {

	private WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	/*
	 * Method to receive readings and store in app database
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public Forecast createOneReading(@RequestBody Forecast weatherReadings) {
		System.out.println(weatherReadings.toString());
		return weatherService.createoOneReading(weatherReadings);
	}

	/*
	 * Method to return weather readings of all cities
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Forecast> findAll() {
		
		return weatherService.findAll();
	}

	/*
	 * Method to return weather reading of the specified city
	 */

	@RequestMapping(method = RequestMethod.GET, value = Constants.CITY_PATH_VARIABLE)
	public Forecast findOne(@PathVariable(value = Constants.CITY_PATH_PARAM) String city) {
		
		return weatherService.findOne(city);
	}

	/*
	 * Method to return weather property of the given city
	 */
	@RequestMapping(method = RequestMethod.GET, value = Constants.CITY_PATH_VARIABLE + Constants.SLASH
			+ Constants.WEATHER_PROPERTY)
	public Object findOneProperty(@PathVariable(value = Constants.CITY_PATH_PARAM) String city,
			@PathVariable(value = Constants.WEATHER_PROPERTY_PARAM) String property) {
		
		return weatherService.findOneProperty(city, property);

	}

}
