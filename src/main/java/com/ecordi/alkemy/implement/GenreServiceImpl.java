package com.ecordi.alkemy.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecordi.alkemy.entities.Genre;
import com.ecordi.alkemy.repositories.GenreRepository;
import com.ecordi.alkemy.services.GenreServices;

@Service
public class GenreServiceImpl implements GenreServices {

	@Autowired
	GenreRepository _genreRepository;
	@Override
	public Genre create(Genre genre) {
		return _genreRepository.save(genre);
	}

	@Override
	public Genre updateById(Genre genre,Long id) {
		Genre genreUpdate =new Genre();
		try {
			if (_genreRepository.existsById(id)) {
				genreUpdate=_genreRepository.getById(id);
				genreUpdate.setId(genre.getId());
				genreUpdate.setName(genre.getName());
				genreUpdate.setImage(genre.getImage());
				genreUpdate.setAssociated_movies(genre.getAssociated_movies());
			}
			return _genreRepository.saveAndFlush(genreUpdate);
		} catch (Exception e) {
			new Exception("Id not found"+e);
			return _genreRepository.saveAndFlush(genre);
		}

	}

	@Override
	public boolean delete(Long id) {
		try {
			if (_genreRepository.existsById(id)) {
				_genreRepository.deleteById(id);
			}
			_genreRepository.deleteRelation(id);
			_genreRepository.deleteById(id);
			return true;

		} catch (Exception e) {
			new Exception("Id not found" + e);
			return false;
		}
	}
	
}
