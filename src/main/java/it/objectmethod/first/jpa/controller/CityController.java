package it.objectmethod.first.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.first.jpa.entity.City;
import it.objectmethod.first.jpa.repository.CitiesRepository;

@RestController
public class CityController {

	@Autowired
	private CitiesRepository repCity;

	/*
	 * @GetMapping("/find-city-by-id") public City findCityById(@RequestParam("id")
	 * Long id) { City finalCity = repCity.findById(id).get(); //N.B. return
	 * finalCity; }
	 */

	@GetMapping("/find-city-by-name")
	public City findCityByName(@RequestParam("name") String name) {
		City finalCity = repCity.findByName(name);
		return finalCity;
	}

	@GetMapping("/find-list-cities-by-nationName")
	public List<City> printListCitiesByNationName(@RequestParam("nationName") String name) {
		List<City> finalList = repCity.findAllByCountryName(name);
		return finalList;
	}

	/*
	 * @GetMapping("/find-list-cities-by-nationCode") 
	 * public List<City> printListCities(@RequestParam("nationCode") String code) { 
	 * List<City> finalList = repCity.findByCountryCode(code); 
	 * return finalList; 
	 * }
	 */

	@GetMapping("/modify-add-city")
	public City modifyExistingCity(@RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("countryCode") String countryCode, @RequestParam("district") String district,
			@RequestParam("population") Long population) {
		City modifiedCity = new City();
		modifiedCity.setId(id);
		modifiedCity.setName(name);
		modifiedCity.setCountryCode(countryCode);
		modifiedCity.setDistrict(district);
		modifiedCity.setPopulation(population);
		repCity.save(modifiedCity);
		return modifiedCity;
	}

	/*
	 * @GetMapping("/remove-city-by-id") 
	 * public void removeCityByName(@RequestParam("id") Long id) { 
	 * repCity.deleteById(id); 
	 * }
	 */

	@GetMapping("/remove-city-by-name")
	public void removeCityByName(@RequestParam("cityName") String name) {
		repCity.removeCityByName(name);
	}

}
