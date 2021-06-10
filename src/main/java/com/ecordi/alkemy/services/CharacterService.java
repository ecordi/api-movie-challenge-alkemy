package com.ecordi.alkemy.services;

import org.springframework.stereotype.Service;

@Service

public interface CharacterService {

public Character create(Character character);
	
	public Character updateById(Long id);
	
	public boolean delete(Long id);
}
