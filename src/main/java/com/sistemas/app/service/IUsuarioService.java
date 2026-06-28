package com.sistemas.app.service;

import java.util.List;

import com.sistemas.app.model.Usuario;

public interface IUsuarioService {

	List<Usuario> listarUsuarios();
    Usuario buscarPorId(Long id);
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
}
