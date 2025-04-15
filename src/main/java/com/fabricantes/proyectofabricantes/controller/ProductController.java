package com.fabricantes.proyectofabricantes.controller;


import com.fabricantes.proyectofabricantes.controller.dto.MakerDTO;
import com.fabricantes.proyectofabricantes.controller.dto.ProductDTO;
import com.fabricantes.proyectofabricantes.entidades.Maker;
import com.fabricantes.proyectofabricantes.entidades.Product;
import com.fabricantes.proyectofabricantes.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private iProductService productService;

    // ✅ GET para buscar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional= productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .nombre(product.getNombre())
                    .precio(product.getPrecio())
                    .maker(product.getMaker())
                    .build();

            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ GET para listar todos Product
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ProductDTO> productList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .nombre(product.getNombre())
                        .precio(product.getPrecio())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productList);
    }

    // ✅ POST para crear nuevo fabricante
    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO) throws URISyntaxException {
        if (productDTO.getNombre() == null || productDTO.getNombre().isBlank() ||
                productDTO.getPrecio() == null || productDTO.getMaker() == null) {
            return ResponseEntity.badRequest().body("Nombre, precio y fabricante son obligatorios.");
          }
        Product product = Product.builder()
                .nombre(productDTO.getNombre())
                .precio(productDTO.getPrecio())
                .maker(productDTO.getMaker())
                .build();
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    // ✅ PUT Actualizar Maker
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) throws URISyntaxException {
        Optional<Product> productOptional = productService.findById(id);
        if(productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setNombre(productDTO.getNombre());
            product.setPrecio(productDTO.getPrecio());
            product.setMaker(productDTO.getMaker());
            productService.save(product);
            return ResponseEntity.ok("Registro Actualizado Correctamente");
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ DELETE Eliminar Maker
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if(id != null) {
            productService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }

}
