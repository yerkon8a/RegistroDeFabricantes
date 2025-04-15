package com.fabricantes.proyectofabricantes.repository;

import com.fabricantes.proyectofabricantes.entidades.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {
}
