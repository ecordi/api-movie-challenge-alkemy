package com.ecordi.alkemy.services;

import org.springframework.stereotype.Service;

import com.ecordi.alkemy.entities.Genre;

@Service
public interface GenreServices {
	
	public Genre create(Genre genre);

	public Genre updateById(Genre genre, Long id);

	public boolean delete(Long id);
}
