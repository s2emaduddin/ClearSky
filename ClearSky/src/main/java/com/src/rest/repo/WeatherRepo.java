package com.src.rest.repo;

import java.util.List;

import com.src.rest.entity.Forecast;

public interface WeatherRepo {

	public List<Forecast> findAll();

	public Forecast findOne(String city);

	public Object findOneProperty(String city, String property);

	public Forecast createoOneReading(Forecast weatherReadings);
}
