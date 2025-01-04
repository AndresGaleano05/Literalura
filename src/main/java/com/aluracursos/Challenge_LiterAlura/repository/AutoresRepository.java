package com.aluracursos.Challenge_LiterAlura.repository;

import com.aluracursos.Challenge_LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository <Autor, Long>{
    Optional<Autor> findByNombreAndFechaDeNacimientoAndFechaDeFallecimiento(String nombre, String fechaDeNacimiento, String fechaDeFallecimiento);

}
