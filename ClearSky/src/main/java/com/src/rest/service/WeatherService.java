package com.src.rest.service;

import java.util.List;

import com.src.rest.entity.Forecast;

public interface WeatherService {

	public List<Forecast> findAll();
	
	public Forecast findOne(String city);
	
	public Object findOneProperty(String city, String property);
		
	public Forecast createoOneReading(Forecast weatherReadings);
}
