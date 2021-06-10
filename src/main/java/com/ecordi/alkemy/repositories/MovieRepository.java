package com.ecordi.alkemy.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecordi.alkemy.entities.Character;
import com.ecordi.alkemy.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

	@Query(value = "SELECT * FROM movies", nativeQuery = true)
	public ArrayList<Object[]> getAll();

	@Transactional
	@Query(value = "SELECT * FROM movies WHERE id=?", nativeQuery = true)
	public Character getMoviesById(Long id);

	@Transactional
	@Query(value = "SELECT * FROM movies WHERE name=?", nativeQuery = true)
	public Character getMoviesByName(String name);

	@Transactional
	@Query(value = "SELECT * FROM movies WHERE genre_id=?", nativeQuery = true)
	public Character getMovieByGenre(Long id);

	@Transactional
	@Query(value = "SELECT * FROM movies ORDER BY cration_date ?", nativeQuery = true)
	public Character moviesByOrder(String order);

}
