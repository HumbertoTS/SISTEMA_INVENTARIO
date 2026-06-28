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
public class UsuarioResponseDTO {
<<<<<<< HEAD
<<<<<<< HEAD
    private Long id_usuario;
=======
    private Long id;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
=======
    private Long id;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
    private String nombre;
    private String username;
    private String rol;
}