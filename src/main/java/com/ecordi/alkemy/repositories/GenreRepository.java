package com.ecordi.alkemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecordi.alkemy.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM  genres_associated_movies  where genre_id=?", nativeQuery = true)
	void deleteRelation(Long movie_id);
	
	
}
