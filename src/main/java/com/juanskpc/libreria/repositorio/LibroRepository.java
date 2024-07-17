package com.juanskpc.libreria.repositorio;

import com.juanskpc.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
