package com.ecordi.alkemy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecordi.alkemy.entities.Character;
import com.ecordi.alkemy.entities.Genre;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{

	
	@Transactional
	@Query(value = "SELECT * FROM characters WHERE name=?", nativeQuery = true)
	public Character getCharacterByName(String name);
	@Transactional
	@Query(value = "SELECT * FROM characters WHERE age=?", nativeQuery = true)
	public Character getCharacterByAge(int age);

	@Transactional
	@Query(value = "SELECT * FROM characters WHERE weigth=?", nativeQuery = true)
	public Genre getCharacterByWeight(float weight);

	@Transactional
	@Query(value = "SELECT * FROM characters c, actuations a WHERE a.id_film=? ", nativeQuery = true)
	public List<Character> getCharacterByIdMovie(int id);
	
}
