package it.objectmethod.first.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.objectmethod.first.jpa.entity.City;

@Repository
public interface CitiesRepository extends JpaRepository<City, Long> {

	public List<City> findByCountryCode(String code);

	@Query(value = "SELECT c FROM City c, Nation g WHERE g.name = :#{#name} AND g.code = c.countryCode")
	public List<City> findAllByCountryName(@Param("name") String name);

	@Query(value = "SELECT c FROM City c WHERE c.name = :#{#name}")
	public City findByName(@Param("name") String name);

	@Query(value = "DELETE FROM City c WHERE c.name = :#{#name}")
	public City removeCityByName(@Param("name") String name);
	
}
