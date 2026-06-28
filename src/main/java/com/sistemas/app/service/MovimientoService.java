package com.sistemas.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemas.app.model.Movimiento;
import com.sistemas.app.model.Producto;
import com.sistemas.app.model.TipoMovimiento;
import com.sistemas.app.repository.MovimientoRepository;
import com.sistemas.app.repository.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoService implements IMovimientoService {	   

	private final MovimientoRepository movimientoRepo;
    private final ProductoRepository productoRepo;

    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {

        Producto producto = productoRepo.findByCodigoProducto(
                movimiento.getProducto().getCodigoProducto()
        ).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        //lógica importante: actualizar stock
        if (movimiento.getTipoMovimiento() == TipoMovimiento.ENTRADA) {
            producto.setStock(producto.getStock() + movimiento.getCantidad());
        } else if (movimiento.getTipoMovimiento() == TipoMovimiento.SALIDA) {
            producto.setStock(producto.getStock() - movimiento.getCantidad());
        }

        movimiento.setProducto(producto);

        productoRepo.save(producto);
        return movimientoRepo.save(movimiento);
    }

    @Override
    public List<Movimiento> listarMovimientos() {
        return movimientoRepo.findAll();
    }

    @Override
    public Movimiento buscarPorId(Long id) {
        return movimientoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movimiento no encontrado"));
    }

    @Override
    public List<Movimiento> buscarPorProducto(String codigoProducto) {
        return movimientoRepo.findByProductoCodigoProductoContainingIgnoreCase(codigoProducto);
    }

}
