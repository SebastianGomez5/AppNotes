package com.backend_app.backend_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.backend_app.backend_app.model.Nota;
import com.backend_app.backend_app.repository.NotaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "http://localhost:5173") //Configuración para permitir solicitudes desde el frontend
public class NotaController {

    private final NotaRepository notaRepository;

    public NotaController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    // Endpoint para obtener todas las notas
    @GetMapping
    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }
    
    // Crear Nota
    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    // Editar Nota
    @PutMapping("/{id}")
    public Nota updateNota(@PathVariable Long id, @RequestBody Nota notaContenido) {
        return notaRepository.findById(id)
            .map(nota -> {
                nota.setTitulo(notaContenido.getTitulo());
                nota.setContenido(notaContenido.getContenido());
                return notaRepository.save(nota);
            })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada con id: " + id));
    }

    //Eliminar Nota
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        if (!notaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada con id: " + id);
        }
        notaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
