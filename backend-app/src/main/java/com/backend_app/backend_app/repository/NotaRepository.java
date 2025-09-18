package com.backend_app.backend_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend_app.backend_app.model.*;
@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

}