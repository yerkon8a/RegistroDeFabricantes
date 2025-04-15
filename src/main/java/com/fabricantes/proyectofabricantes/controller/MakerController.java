package com.fabricantes.proyectofabricantes.controller; // ✅ Bien, aunque normalmente se usa "com.tuempresa.controller"

import com.fabricantes.proyectofabricantes.controller.dto.MakerDTO;
import com.fabricantes.proyectofabricantes.entidades.Maker;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fabricantes.proyectofabricantes.service.iMakerService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private iMakerService makerService;

    // ✅ GET para buscar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .nombre(maker.getNombre())
                    .build();

            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ GET para listar todos
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        List<MakerDTO> makerList = makerService.findAll()
        .stream()
        .map(maker -> MakerDTO.builder()
                .id(maker.getId())
                .nombre(maker.getNombre())
                .producList(maker.getProducList())
                .build())
                .toList();
        return ResponseEntity.ok(makerList);
    }

    // ✅ POST para crear nuevo fabricante
    @PostMapping("/save")
    public ResponseEntity<?> saveMaker(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
        if(makerDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
    }
        makerService.save(Maker.builder()
        .nombre(makerDTO.getNombre())
                .build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    // ✅ PUT Actualizar Maker
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO) throws URISyntaxException {
        Optional<Maker> makerOptional = makerService.findById(id);
        if(makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setNombre(makerDTO.getNombre());
            makerService.save(maker);
            return ResponseEntity.ok("Registro Actualizado Correctamente");
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ DELETE Eliminar Maker
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMaker(@PathVariable Long id) {
        if(id != null) {
            makerService.deleteByid(id);
            return ResponseEntity.ok("Registro Eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}
