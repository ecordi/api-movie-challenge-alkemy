package com.ecordi.alkemy.services;

import org.springframework.stereotype.Service;

import com.ecordi.alkemy.entities.Character;

@Service

public interface CharacterService {

	public Character create(Character character);

	public Character updateById(Character character, Long id);

	public boolean delete(Long id);
}
