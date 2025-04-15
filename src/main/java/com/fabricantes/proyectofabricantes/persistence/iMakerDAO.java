package com.fabricantes.proyectofabricantes.persistence;

import com.fabricantes.proyectofabricantes.entidades.Maker;

import java.util.List;
import java.util.Optional;

public interface iMakerDAO {
    List<Maker> findAll();
    Optional<Maker> findById(Long id);
    void save(Maker maker);
    void deleteByid(Long id);
}
