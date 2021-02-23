package it.objectmethod.first.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Nation {

	@GeneratedValue
	@Id
	private String code;

	@Column(name = "Name")
	private String name;

	@Column(name = "Continent")
	private String continent;

	@Column(name = "Population")
	private Long population;

	@Column(name = "SurfaceArea")
	private Long surfaceArea;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public long getSurfaceAea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Long surfaceAea) {
		this.surfaceArea = surfaceAea;
	}

}
