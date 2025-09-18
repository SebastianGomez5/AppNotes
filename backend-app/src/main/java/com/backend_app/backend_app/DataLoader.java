package com.backend_app.backend_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backend_app.backend_app.model.Nota;
import com.backend_app.backend_app.repository.NotaRepository;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDatabase(NotaRepository notaRepository) {
        return args -> {
            // Evita insertar duplicados al reiniciar
            if (notaRepository.count() == 0) {
                notaRepository.save(new Nota("Primera nota", "Contenido de la primera nota"));
                notaRepository.save(new Nota("Segunda nota", "Contenido de la segunda nota"));
                notaRepository.save(new Nota("Tarea", "Recordar estudiar Spring Boot"));
            }
        };
    }
    
}
