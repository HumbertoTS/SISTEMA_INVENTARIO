package com.sistemas.app.service;

import com.sistemas.app.dto.LoginDTO;
import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.dto.UsuarioResponseDTO;

public interface ILoginService {
    String login(LoginDTO login);
    UsuarioResponseDTO createUser(UsuarioRequestDTO usuario);
}