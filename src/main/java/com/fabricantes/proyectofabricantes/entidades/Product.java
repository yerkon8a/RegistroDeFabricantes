package com.fabricantes.proyectofabricantes.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Data
@Entity
@Table(name = "producto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "precio", length = 30, nullable = false)
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name="id_fabricante" , nullable = false)
    @JsonIgnore
    private Maker maker;
}
