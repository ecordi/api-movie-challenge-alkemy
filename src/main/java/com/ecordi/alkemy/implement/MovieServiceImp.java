package com.ecordi.alkemy.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecordi.alkemy.entities.Movie;
import com.ecordi.alkemy.repositories.MovieRepository;
import com.ecordi.alkemy.services.MovieService;

public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository _movieRepository;

	/**
	 * 
	 */
	@Override
	public Movie create(Movie movie) {
		return _movieRepository.save(movie);
	}

	/**
	 * @param movie
	 * @param id
	 */
	@Override
	public Movie updateById(Movie movie, Long id) {
		Movie movieUpdate = null;
		try {
			if (_movieRepository.existsById(id)) {
				movieUpdate = _movieRepository.getById(id);
				movieUpdate.setId(movie.getId());
				movieUpdate.setImage(movie.getImage());
				movieUpdate.setTitle(movie.getTitle());
				movieUpdate.setCreation_date(movie.getCreation_date());
				movieUpdate.setQualification(movie.getQualification());
				movieUpdate.setAssociated_characters(movie.getAssociated_characters());
				movieUpdate.setGender(movie.getGender());
			}
			return _movieRepository.saveAndFlush(movieUpdate);
		} catch (Exception e) {
			new Exception("Id not found" + e);
			return _movieRepository.saveAndFlush(movie);
		}

	}

	/**
	 * @param id
	 */
	@Override
	public boolean delete(Long id) {
		try {
			if (_movieRepository.existsById(id)) {
				_movieRepository.deleteById(id);
			}
			return true;

		} catch (Exception e) {
			new Exception("Id not found" + e);
			return false;
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Movie> getMovieByName(String name) {
		return _movieRepository.getMovieByName(name);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Movie> getMovieByGenre(Long id) {
		return _movieRepository.getMovieByGenre(id);
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public List<Movie> moviesByOrder(String order) {
		if (order.equals("ASC")) {
			return (ArrayList<Movie>) _movieRepository.moviesByOrder("ASC");
		} else if (order.equals("DESC")) {
			return (ArrayList<Movie>) _movieRepository.moviesByOrder("DESC");
		} else {
			return (ArrayList<Movie>) _movieRepository.findAll();
		}
	}
}
