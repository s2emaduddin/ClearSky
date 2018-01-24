package com.src.rest.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Weather.findAll", query = "SELECT f from Forecast f"),
		@NamedQuery(name = "Weather.findByCity", query = "SELECT f from Forecast f where f.city = :city"),

})
public class Forecast {

	@Id
	private String Id;
	private String city;
	private String description;
	private int humidity;
	private long pressure;
	private int temperature;
	
	private Date timestamp;
	


	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Wind wind;

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Forecast() {
		this.Id = UUID.randomUUID().toString();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public long getPressure() {
		return pressure;
	}

	public void setPressure(long pressure) {
		this.pressure = pressure;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "WeatherReadings [Id=" + Id + ", city=" + city + ", description=" + description + ", humidity="
				+ humidity + ", pressure=" + pressure + ", temperature=" + temperature + ", timestamp=" + timestamp
				+ "]";
	}

}
