package com.src.rest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.src.rest.exception.NotFoundException;
import com.src.rest.entity.Forecast;
import com.src.rest.repo.WeatherRepo;
import com.src.rest.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	private WeatherRepo weatherRepo;

	public WeatherServiceImpl(WeatherRepo weatherRepo) {

		this.weatherRepo = weatherRepo;
	}

	@Override
	@Transactional
	public Forecast createoOneReading(Forecast weatherReadings) {

		return weatherRepo.createoOneReading(weatherReadings);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Forecast> findAll() {

		return weatherRepo.findAll();
	}

	@Override
	public Forecast findOne(String city) {

		Forecast existing = weatherRepo.findOne(city);

		if (existing == null) {

			throw new NotFoundException("No data for given city");

		}

		return weatherRepo.findOne(city);
	}

	@Override
	public Object findOneProperty(String city, String property) {

		Forecast existing = weatherRepo.findOne(city);

		if (existing == null) {

			throw new NotFoundException("No data for given city");

		}

		return weatherRepo.findOneProperty(city, property);
	}

}
