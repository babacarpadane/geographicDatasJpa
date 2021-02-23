package it.objectmethod.first.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.first.jpa.entity.Nation;

@Repository
public interface NationsRepository extends JpaRepository<Nation, String> {

	public List<Nation> findByContinent(String continentName);

	@Query(value = "SELECT c FROM Nation c WHERE c.name = :#{#nationName}")
	public Nation findByName(@Param("nationName") String name);

	@Query(value = "DELETE FROM Nation c WHERE c.name = :#{#nationName}")
	public void removeNationByName(@Param("nationName") String name);
	
}
