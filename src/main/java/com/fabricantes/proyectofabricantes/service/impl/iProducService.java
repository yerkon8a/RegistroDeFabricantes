package com.fabricantes.proyectofabricantes.service.impl;

import com.fabricantes.proyectofabricantes.entidades.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabricantes.proyectofabricantes.persistence.iProductDAO;
import com.fabricantes.proyectofabricantes.service.iProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class iProducService implements iProductService {

    @Autowired
    private iProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }
}
