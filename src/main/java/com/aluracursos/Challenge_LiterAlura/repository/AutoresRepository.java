package com.aluracursos.Challenge_LiterAlura.repository;

import com.aluracursos.Challenge_LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository <Autor, Long>{
    Optional<Autor> findByNombreAndFechaDeNacimientoAndFechaDeFallecimiento(String nombre, Integer fechaDeNacimiento, Integer fechaDeFallecimiento);

    @Query("SELECT a FROM Autor a WHERE (a.fechaDeFallecimiento IS NULL OR a.fechaDeFallecimiento > :año) AND a.fechaDeNacimiento <= :año")
    List<Autor> findAutoresVivosEnAño(@Param("año") int año);
}
