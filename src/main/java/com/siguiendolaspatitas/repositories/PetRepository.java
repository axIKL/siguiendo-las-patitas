package com.siguiendolaspatitas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siguiendolaspatitas.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findAll(); // Listar todos los pets
    List<Pet> findByName(String name); // Listar pets por nombre
    List<Pet> findByEspecieName(String name); // Listar pets por especie
    List<Pet> findByOwnerId(Long id); // Listar pets por dueño
}
