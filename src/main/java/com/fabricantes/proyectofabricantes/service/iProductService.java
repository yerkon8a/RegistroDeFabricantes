package com.fabricantes.proyectofabricantes.service;

import com.fabricantes.proyectofabricantes.entidades.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface iProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    void save(Product product);
    void deleteById(Long id);
}
