package com.ecordi.alkemy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecordi.alkemy.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
