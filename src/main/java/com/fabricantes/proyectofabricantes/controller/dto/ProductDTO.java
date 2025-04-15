package com.fabricantes.proyectofabricantes.controller.dto;
import com.fabricantes.proyectofabricantes.entidades.Maker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Maker maker;
}
