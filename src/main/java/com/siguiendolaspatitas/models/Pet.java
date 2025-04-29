package com.siguiendolaspatitas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photo;

    @NotNull(message="Se requiere un nombre")
	@Size(max=40, message="el nombre ingresado demasiado largo")
    private String name;

    @NotNull(message="Se requiere una especie")
    private String species;

    @NotNull(message="Se requiere genero")
    private String gender;

    @NotNull(message="Se requiere una edad")
    
    private String age;

    private String size;

    private String description;


}
