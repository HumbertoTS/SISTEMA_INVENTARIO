package com.sistemas.app.service;

import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
import com.sistemas.app.model.Producto;

public interface IProductoService {
    Producto createProducto(Producto producto);
    List<Producto> getAllProductos();
=======
=======
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
import com.sistemas.app.dto.ProductoDTO;

public interface IProductoService {
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO getProductoByCodigo(String codigoProducto);
    List<ProductoDTO> getAllProductos();
    ProductoDTO updateProducto(ProductoDTO productoDTO);
    void deleteProducto(String codigoProducto);
    List<ProductoDTO> buscarProductos(String texto);
<<<<<<< HEAD
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
=======
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
}
