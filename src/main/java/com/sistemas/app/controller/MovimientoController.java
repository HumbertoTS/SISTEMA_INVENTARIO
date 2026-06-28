package com.sistemas.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistemas.app.model.Movimiento;
import com.sistemas.app.model.Usuario;
import com.sistemas.app.repository.UsuarioRepository;
import com.sistemas.app.service.IMovimientoService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/movimiento")
@RequiredArgsConstructor
public class MovimientoController {

	private final IMovimientoService movimientoService;
	private final UsuarioRepository usuarioRepository;

	@GetMapping("/listar")
	public String mostrarLista(Authentication authentication, Model model) {

	    // Usuario autenticado
	    model.addAttribute("usuario", authentication.getName());

	    // Lista de movimientos
	    model.addAttribute("movimientos", movimientoService.listarMovimientos());
	    return "listar-movimiento";
	}


    // Mostrar formulario de nuevo movimiento
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("movimiento", new Movimiento());
        return "agregar-movimiento";
    }

    // Guardar movimiento
    @PostMapping
    public String guardarMovimiento(@ModelAttribute Movimiento movimiento, Principal principal) {
    	String username = principal.getName();

    	Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Lo asignas al movimiento
        movimiento.setUsuario(usuario);
        movimientoService.crearMovimiento(movimiento);
        return "redirect:/movimiento/listar";
    }

    // Buscar por producto
    @GetMapping("/buscar")
    public String buscarPorProducto(@RequestParam("codigo") String codigoProducto, Model model) {
    	List<Movimiento> resultados = movimientoService.buscarPorProducto(codigoProducto);
        model.addAttribute("movimientos", resultados);
        model.addAttribute("codigoBuscado", codigoProducto);
        return "listar-movimiento :: tabla-movimiento";
    }

    // Eliminar movimiento
    @GetMapping("/eliminar/{id}")
    public String eliminarMovimiento(@PathVariable Long id) {
        // Podrías implementar un método eliminar en el service si lo necesitas
        return "redirect:/movimiento/listar";
    }
}
