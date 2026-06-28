package com.sistemas.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.app.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    Optional<Movimiento> findById(Long movimientoId);
    List<Movimiento> findByProductoCodigoProductoContainingIgnoreCase(String codigoProducto);
    
}
