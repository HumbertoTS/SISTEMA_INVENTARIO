package com.sistemas.app.mapper;

import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;
import com.sistemas.app.model.Usuario;

public class Mapper {
    
    public static Usuario toUsuarioEntity(UsuarioRequestDTO obj) {
        return Usuario.builder()
                .nombre(obj.getNombre())
                .apellido(obj.getApellido())
                .username(obj.getUsername())
                .password(obj.getPassword())
                .rol(obj.getRol())
                .build();
    }

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario obj) {
        return UsuarioResponseDTO.builder()
                .id_usuario(obj.getId())
                .nombre(obj.getNombre())
                .username(obj.getUsername())
                .rol(obj.getRol())
                .build();
    }
}
