package com.aluracursos.Challenge_LiterAlura.repository;

import com.aluracursos.Challenge_LiterAlura.Model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository <Libros, Long> {
    @Query("SELECT l FROM Libros l WHERE l.titulo = :titulo")
    Optional<Libros> verificarPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT l FROM Libros l WHERE l.idiomas =:idiomas")
    List<Libros> registroPorIdiomas(@Param("idiomas") String idiomas);
}
