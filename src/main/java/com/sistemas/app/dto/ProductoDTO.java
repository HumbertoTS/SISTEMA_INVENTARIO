package com.sistemas.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

    private String codigoProducto;
    private String nombre;
    private String descripcion;
    private String unidad;
    private Integer stock;
    private Long categoriaId;
<<<<<<< HEAD
=======
    private String categoriaNombre;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334

}
