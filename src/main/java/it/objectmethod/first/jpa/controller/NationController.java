package it.objectmethod.first.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import it.objectmethod.first.jpa.entity.City;
import it.objectmethod.first.jpa.entity.Nation;
import it.objectmethod.first.jpa.repository.NationsRepository;

@RestController
public class NationController {

	@Autowired
	private NationsRepository repNation;

	/*
	 * @GetMapping("/find-nation-by-code") 
	 * public Nation printNation(@RequestParam("code") String code) { 
	 * Nation finalNation = repNation.findById(code).get(); 
	 * return finalNation; 
	 * }
	 */

	@GetMapping("/find-nation-by-name")
	public Nation findNationByName(@RequestParam("nationName") String name) {
		Nation finalCity = repNation.findByName(name);
		return finalCity;
	}

	@GetMapping("/find-list-nations-by-continent")
	public List<Nation> printListNations(@RequestParam("continent") String continent) {
		List<Nation> finalList = repNation.findByContinent(continent);
		return finalList;
	}

	@GetMapping("/modify-nation")
	public Nation modifyExistingNation(@RequestParam("code") String code, @RequestParam("name") String name,
			@RequestParam("continent") String continent, @RequestParam("population") Long population,
			@RequestParam("surfaceArea") Long surfaceArea) {
		Nation modifiedNation = new Nation();
		modifiedNation.setCode(code);
		modifiedNation.setName(name);
		modifiedNation.setContinent(continent);
		modifiedNation.setPopulation(population);
		modifiedNation.setSurfaceArea(surfaceArea);
		repNation.save(modifiedNation);
		return modifiedNation;
	}
	
	/*
	 * @GetMapping("/remove-nation-by-code") 
	 * public void removeNationByName(@RequestParam("code") String code) { 
	 * repNation.deleteById(code); 
	 * }
	 */

	@GetMapping("/remove-nation-by-name")
	public void removeNationByName(@RequestParam("nationName") String name) {
		repNation.removeNationByName(name);
	}

}
