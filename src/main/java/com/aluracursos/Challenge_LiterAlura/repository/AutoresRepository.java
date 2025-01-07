package com.aluracursos.Challenge_LiterAlura.repository;

import com.aluracursos.Challenge_LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository <Autor, Long>{
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre AND (a.fechaDeNacimiento = :fechaDeNacimiento OR a.fechaDeNacimiento IS NULL) AND (a.fechaDeFallecimiento = :fechaDeFallecimiento OR a.fechaDeFallecimiento IS NULL)")
    Optional<Autor> obtenerAutorCrearAutor(
            @Param("nombre") String nombre,
            @Param("fechaDeNacimiento") Integer fechaDeNacimiento,
            @Param("fechaDeFallecimiento") Integer fechaDeFallecimiento);


    @Query("SELECT a FROM Autor a WHERE (a.fechaDeFallecimiento IS NULL OR a.fechaDeFallecimiento > :año) AND a.fechaDeNacimiento <= :año")
    List<Autor> AutoresVivosPorAño(@Param("año") int año);
}
