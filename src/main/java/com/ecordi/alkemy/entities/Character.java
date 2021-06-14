/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecordi.alkemy.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Creacion de Metodos Getters and setters with lombok*
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Data
@Entity
@Table(name = "characters")
public class Character implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7185505026487441228L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "name")	
	private String name;
	
	@Column(name = "image")
	@Lob
	private String image;

	@NotNull
	@Min(1)
	@Column(name="age")
	private int age;

	@NotNull
	@Min(1)
	@Column(name="weight")
	private float weight;
	
	@NotEmpty
	@Column(name="story")
	private String story;
        
	@ManyToMany(mappedBy = "associated_characters")
	private Set<Movie> associated_movies;

}