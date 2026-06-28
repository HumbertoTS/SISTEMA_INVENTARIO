package com.sistemas.app.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistemas.app.model.Usuario;
import com.sistemas.app.repository.MovimientoRepository;
import com.sistemas.app.repository.ProductoRepository;
import com.sistemas.app.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

	private final UsuarioRepository usuarioRepo;
	private final PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        if (usuario.getId() != null) {
            // Buscar el usuario existente
            Usuario existente = usuarioRepo.findById(usuario.getId()).orElse(null);
            if (existente != null) {
                // Si el campo password está vacío → conservar la anterior
                if (usuario.getPassword() == null || usuario.getPassword().isBlank()) {
                    usuario.setPassword(existente.getPassword());
                } else {
                    // Si se ingresó una nueva contraseña → encriptar
                    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
                }
            }
        } else {
            // Usuario nuevo → siempre encriptar
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }

        usuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }
}
