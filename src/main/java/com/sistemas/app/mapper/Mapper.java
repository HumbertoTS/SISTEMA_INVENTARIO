package com.sistemas.app.mapper;

<<<<<<< HEAD
import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;
=======
import com.sistemas.app.dto.ProductoDTO;
import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;
import com.sistemas.app.model.Producto;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
import com.sistemas.app.model.Usuario;

public class Mapper {
    
    public static Usuario toUsuarioEntity(UsuarioRequestDTO obj) {
        return Usuario.builder()
                .nombre(obj.getNombre())
<<<<<<< HEAD
=======
                .email(obj.getEmail())
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
                .apellido(obj.getApellido())
                .username(obj.getUsername())
                .password(obj.getPassword())
                .rol(obj.getRol())
                .build();
    }

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario obj) {
        return UsuarioResponseDTO.builder()
<<<<<<< HEAD
                .id_usuario(obj.getId())
=======
                .id(obj.getId())
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
                .nombre(obj.getNombre())
                .username(obj.getUsername())
                .rol(obj.getRol())
                .build();
    }
<<<<<<< HEAD
=======

    public static ProductoDTO toProductoDTO(Producto obj) {
        return ProductoDTO.builder()
                .codigoProducto(obj.getCodigoProducto())
                .nombre(obj.getNombre())
                .descripcion(obj.getDescripcion())
                .unidad(obj.getUnidad())
                .stock(obj.getStock())
                .categoriaId(obj.getCategoria().getId())
                .categoriaNombre(obj.getCategoria().getNombre())
                .build();
    }
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
}
