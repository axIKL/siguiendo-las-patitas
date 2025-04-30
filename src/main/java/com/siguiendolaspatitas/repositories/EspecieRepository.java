package com.siguiendolaspatitas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siguiendolaspatitas.models.Especie;

@Repository
public interface EspecieRepository extends CrudRepository<Especie, Long> {
    
        // Listar todas las especies
        List<Especie> findAll(); 
    
        // Listar especies por nombre
        List<Especie> findByName(String name); 

        // Eliminar una especie por id
        void deleteById(Long id);
}
