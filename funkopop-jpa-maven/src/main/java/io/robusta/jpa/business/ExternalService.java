package io.robusta.jpa.business;

import java.util.Optional;

import feign.Feign;

public class ExternalService {

	public Optional<Boolean> isWeatherGood(){
		return Optional.of(true);
	}
	
	public Optional<Integer> getTravelTime(double originLatitude, double originLongitude,
			double destinationLatitude, double destinationLongitude){
		
		String origin = originLatitude + ", " + originLongitude;
		String destination = destinationLatitude + ", " + destinationLongitude;

		String url = "https://maps.googleapis.com/maps/api";
		String apiKey = "AIzaSyDJluJ1olY-2KLGOqU9YDXs67wsCmIZkng";

		//Feign feign = Feign.builder().
		//return (int) result.routes[0].legs[0].duration.value;
		

		return Optional.of(150);
	}
}
