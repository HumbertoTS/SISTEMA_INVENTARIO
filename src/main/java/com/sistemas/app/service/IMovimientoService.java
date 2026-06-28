package com.sistemas.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemas.app.model.Movimiento;

@Service
public interface IMovimientoService {

	Movimiento crearMovimiento(Movimiento movimiento);

    List<Movimiento> listarMovimientos();

    Movimiento buscarPorId(Long id);

    List<Movimiento> buscarPorProducto(String codigoProducto);
    
}
