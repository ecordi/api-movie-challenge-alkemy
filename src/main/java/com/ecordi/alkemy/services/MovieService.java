package com.ecordi.alkemy.services;

import org.springframework.stereotype.Service;

import com.ecordi.alkemy.entities.Movie;

@Service
public interface MovieService {

	public Movie create(Movie movie);

	public Movie updateById(Movie movie,Long id);

	public boolean delete(Long id);
}
