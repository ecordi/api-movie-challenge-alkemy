/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecordi.alkemy.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*Creation of metods Getters and setters with lombok*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
/**
 * *
 */

@Data
@Entity
@Table(name = "movies")

public class Movie implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6348587719835971578L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image", nullable = true)
    @Lob()
    private String image;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @NotNull
    @Column(name = "creation_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date creation_date;

    @Column(name = "qualification")
    @NotNull
    @Min(1)
    @Max(5)
    private int qualification;

    @ManyToMany
    @JoinTable(name = "actuations",
            joinColumns = @JoinColumn(name = "id_Character"),
            inverseJoinColumns = @JoinColumn(name = "id_Movie"))
    private Set<Character> associated_characters;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Genre")
    private Genre gender;
}
