package com.ecordi.alkemy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecordi.alkemy.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Transactional
	@Query(value = "SELECT * FROM movies WHERE name=?", nativeQuery = true)
	public List<Movie> getMovieByName(String name);

	@Transactional
	@Query(value = "SELECT * FROM movies WHERE genre_id=?", nativeQuery = true)
	public List<Movie> getMovieByGenre(Long id);

	@Transactional
	@Query(value = "SELECT * FROM movies ORDER BY cration_date ?", nativeQuery = true)
	public List<Movie> moviesByOrder(String order);

}
