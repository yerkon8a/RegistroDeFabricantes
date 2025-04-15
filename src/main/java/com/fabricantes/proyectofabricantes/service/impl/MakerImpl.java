package com.fabricantes.proyectofabricantes.service.impl;


import com.fabricantes.proyectofabricantes.entidades.Maker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabricantes.proyectofabricantes.persistence.iMakerDAO;
import com.fabricantes.proyectofabricantes.service.iMakerService;

import java.util.List;
import java.util.Optional;

@Service
public class MakerImpl implements iMakerService {

    @Autowired
    private iMakerDAO makerDAO;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);
    }

    @Override
    public void deleteByid(Long id) {
        makerDAO.deleteByid(id);
    }
}
