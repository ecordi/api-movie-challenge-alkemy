package com.ecordi.alkemy.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecordi.alkemy.entities.Character;
import com.ecordi.alkemy.entities.Movie;

@Repository
public interface GenreRepository extends CrudRepository<Movie, Long>{
	@Query(value = "SELECT * FROM genres", nativeQuery = true)
	public ArrayList<Object[]> getAll();
	
	@Transactional
	@Query(value = "Select * from genres where id=?", nativeQuery = true)
	public Character getChractaerById(Long id);

}
