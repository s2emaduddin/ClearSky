package com.src.rest.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.src.rest.entity.Forecast;
import com.src.rest.repo.WeatherRepo;

@Repository
public class WeatherRepoImpl implements WeatherRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Forecast> findAll() {

		TypedQuery<Forecast> query = em.createNamedQuery("Weather.findAll", Forecast.class);

		return query.getResultList();
	}

	@Override
	public Forecast findOne(String city) {
		TypedQuery<Forecast> query = em
				.createQuery("SELECT f FROM Forecast f where f.city = :city ", Forecast.class);
		query.setParameter("city", city);

		return query.getSingleResult();
	}

	@Override
	public Object findOneProperty(String city, String property) {

		
		TypedQuery<Object> query = em
				.createQuery("SELECT f." + property + " FROM Forecast f where f.city = :city ", Object.class);
		query.setParameter("city", city);
		return	query.getSingleResult();
	}

	@Override
	public Forecast createoOneReading(Forecast weatherReadings) {
		em.persist(weatherReadings);
		return weatherReadings;
	}

}
