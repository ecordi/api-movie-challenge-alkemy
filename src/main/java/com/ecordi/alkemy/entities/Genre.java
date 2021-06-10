/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecordi.alkemy.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*Creacion de Metodos Getters and setters with lombok*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
/****/

@Data
@Entity
@Table(name = "genres")
public class Genre implements Serializable {

	private static final long serialVersionUID = 1l;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "name")
	private String name;
	@JsonIgnoreProperties
	@Column(name = "image")
	private String image;
	@JsonIgnoreProperties
	@OneToMany
	private Set<Movie> associated_films = new HashSet<>();
}