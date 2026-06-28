package com.sistemas.app.service;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.jspecify.annotations.Nullable;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
=======
import org.jspecify.annotations.Nullable;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
import org.springframework.stereotype.Service;

import com.sistemas.app.model.Categoria;
import com.sistemas.app.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepo;

    @Override
    public Categoria createCategoria(Categoria newCategoria) {
        Categoria categoriaSaved = categoriaRepo.save(newCategoria);
        return categoriaSaved;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
    public @Nullable Object getAllCategorias() {
        return categoriaRepo.findAll();
    }

<<<<<<< HEAD
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
=======
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
}
