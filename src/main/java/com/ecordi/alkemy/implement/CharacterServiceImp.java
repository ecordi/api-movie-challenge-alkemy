package com.ecordi.alkemy.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecordi.alkemy.entities.Character;
import com.ecordi.alkemy.entities.Genre;
import com.ecordi.alkemy.repositories.CharacterRepository;
import com.ecordi.alkemy.services.CharacterService;
@Service
public class CharacterServiceImp implements CharacterService {

	@Autowired
	CharacterRepository _characterReposiitory;
	/**
	 * 
	 */
	@Override
	public Character create(Character character) {
		
		return _characterReposiitory.save(character);
	}
	/**
	 * 
	 */
	@Override
	public Character updateById(Character character,Long id) {
		
		Character characterUpdate =new Character();
		try {
			if (_characterReposiitory.existsById(id)) {
				characterUpdate=_characterReposiitory.getById(id);
				characterUpdate.setId(character.getId());
				characterUpdate.setImage(character.getImage());
				characterUpdate.setName(character.getName());
				characterUpdate.setAge(character.getAge());
				characterUpdate.setWeight(character.getWeight());
				characterUpdate.setStory(character.getStory());
				characterUpdate.setAssociated_movies(character.getAssociated_movies());
			}
			return _characterReposiitory.saveAndFlush(characterUpdate);
		} catch (Exception e) {
			new Exception("Id not found"+e);
			return _characterReposiitory.saveAndFlush(character);
		}
	}
	/**
	 * 
	 */
	@Override
	public boolean delete(Long id) {
		try {
			if (_characterReposiitory.existsById(id)) {
				_characterReposiitory.deleteById(id);
			}
			return true;

		} catch (Exception e) {
			new Exception("Id not found" + e);
			return false;
		}
	}

	public Character getCharacterById(Long id) {
		return _characterReposiitory.getById(id);
	}

	public Character getCharacterByName(String name) {
		return _characterReposiitory.getCharacterByName(name);}



	public Genre getCharacterByWeight(float weight) {
		return _characterReposiitory.getCharacterByWeight(weight);
	}

	public List<Character> getCharacterByIdMovie(int id) {
		return _characterReposiitory.getCharacterByIdMovie(id);}

}
