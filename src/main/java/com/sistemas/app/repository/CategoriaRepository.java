package com.sistemas.app.repository;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.app.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findById(Long id);
<<<<<<< HEAD
=======
    List<Categoria> findAll();
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
}
