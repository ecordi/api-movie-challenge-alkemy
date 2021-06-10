package com.ecordi.alkemy.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecordi.alkemy.entities.Character;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long>{

	@Query(value = "SELECT * FROM characters", nativeQuery = true)
	public ArrayList<Object[]> getAll();
	
	@Transactional
	@Query(value = "SELECT * FROM characteres WHERE id=?", nativeQuery = true)
	public Character getChractaerById(Long id);
	@Transactional
	@Query(value = "SELECT * FROM characteres WHERE name=?", nativeQuery = true)
	public Character getChractaerByName(String name);
	@Transactional
	@Query(value = "SELECT * FROM characteres WHERE age=?", nativeQuery = true)
	public Character getChractaerByAge(int age);
	@Transactional
	@Query(value = "SELECT * FROM characteres c, actuations a WHERE a.id_film=? ", nativeQuery = true)
	public List<Character> getChractaerByIdMovie(int id);
	
}
