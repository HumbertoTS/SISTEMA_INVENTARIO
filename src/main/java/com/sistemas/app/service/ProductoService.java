package com.sistemas.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.app.model.Producto;
import com.sistemas.app.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
    private ProductoRepository productoRepository;

    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorCodigo(String codigoProducto) {
        return productoRepository.findByCodigoProducto(codigoProducto);
    }

    public void eliminarProducto(String codigoProducto) {
        productoRepository.deleteById(codigoProducto);
    }
}
