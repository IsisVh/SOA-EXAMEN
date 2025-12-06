package com.UV.uniAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.UV.uniAPI.model.Calificacion;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

    List<Calificacion> findByMatricula(String matricula);
}
