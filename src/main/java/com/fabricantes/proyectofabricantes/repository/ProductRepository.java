package com.fabricantes.proyectofabricantes.repository;

import com.fabricantes.proyectofabricantes.entidades.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

   // Notacion Query
    @Query("SELECT p FROM Product p WHERE p.precio BETWEEN ?1 AND ?2")
    List<Product> findProductByPrecioInRango(        //PrecioInRango es una variable que yo genero
            BigDecimal minPrice, BigDecimal maxPrice
    );

 /*   //Query Metodos
    List<Product> findProductByPrecioBetween(
            BigDecimal minPrecio, BigDecimal maxPrecio
    );*/
}
