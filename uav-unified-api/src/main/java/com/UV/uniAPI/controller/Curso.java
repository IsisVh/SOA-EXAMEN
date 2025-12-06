package com.UV.uniAPI.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.UV.uniAPI.repository.CursoDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class Curso {

    private final CursoDTO cursoRepository;

    public Curso(CursoDTO cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    
    @PostMapping
    public ResponseEntity<Curso> registrarCurso(@RequestBody Curso curso) {
        Curso guardado = cursoRepository.saveAll(curso);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPorId(@PathVariable Long id) {
        return cursoRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(404)
                        .body("Curso no encontrado con id: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {
        if (!cursoRepository.existsById(id)) {
            return ResponseEntity
                    .status(404)
                    .body("No existe curso con id: " + id);
        }
        cursoRepository.deleteById(id);
        return ResponseEntity.ok("Curso eliminado correctamente (id=" + id + ")");
    }

  
    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<?> eliminarPorNombre(@PathVariable String nombre) {
        long eliminados = cursoRepository.deleteByNombre(nombre);
        if (eliminados == 0) {
            return ResponseEntity
                    .status(404)
                    .body("No se encontraron cursos con nombre: " + nombre);
        }
        return ResponseEntity.ok("Cursos eliminados con nombre '" + nombre + "': " + eliminados);
    }

    
    @DeleteMapping("/fecha-inicio/{fecha}")
    public ResponseEntity<?> eliminarPorFechaInicio(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        long eliminados = cursoRepository.deleteByFechaInicio(fecha);
        if (eliminados == 0) {
            return ResponseEntity
                    .status(404)
                    .body("No se encontraron cursos con fecha de inicio: " + fecha);
        }
        return ResponseEntity.ok("Cursos eliminados con fecha de inicio " + fecha + ": " + eliminados);
    }


    @GetMapping
    public List<com.UV.uniAPI.model.Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}
