package com.sistemas.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.app.model.Usuario;
import com.sistemas.app.repository.UsuarioRepository;
import com.sistemas.app.service.IMovimientoService;
import com.sistemas.app.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final IUsuarioService usuarioService;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();        
        model.addAttribute("usuario", usuarios);
        return "usuario-listar";
    }
    
 // Nuevo usuario
    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        // Si es edición (usuario.id != null)
        if (usuario.getId() != null) {
            Usuario existente = usuarioService.buscarPorId(usuario.getId());
            if (existente != null) {
                // Si el campo password está vacío, conservar el anterior
                if (usuario.getPassword() == null || usuario.getPassword().isBlank()) {
                    usuario.setPassword(existente.getPassword());
                }
            }
        }

        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    // Editar usuario
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);        
        model.addAttribute("usuario", usuario);
        return "usuario-editar";
    }

    // Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuario/listar";
    }
    
}
