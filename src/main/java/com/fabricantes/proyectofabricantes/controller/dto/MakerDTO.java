package com.fabricantes.proyectofabricantes.controller.dto;

import com.fabricantes.proyectofabricantes.entidades.Product;
import lombok.*;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private Long id;
    private String nombre;
    private List<Product> producList = new ArrayList<>();
    }

