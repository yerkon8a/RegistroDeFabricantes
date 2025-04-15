package com.fabricantes.proyectofabricantes.persistence.impl;

import com.fabricantes.proyectofabricantes.entidades.Maker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fabricantes.proyectofabricantes.persistence.iMakerDAO;
import com.fabricantes.proyectofabricantes.repository.MakerRepository;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements iMakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id) ;
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void deleteByid(Long id) {
        makerRepository.deleteById(id);
    }
}
