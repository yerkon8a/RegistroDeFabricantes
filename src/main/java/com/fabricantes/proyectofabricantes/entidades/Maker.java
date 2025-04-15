package com.fabricantes.proyectofabricantes.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Data
@Entity
@Table(name = "fabricante")
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

   @OneToMany(mappedBy = "maker" , cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
   @JsonIgnore
    private List<Product> producList = new ArrayList<>();

}
