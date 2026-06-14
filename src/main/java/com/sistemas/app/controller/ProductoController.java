package com.sistemas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.app.model.Producto;
import com.sistemas.app.repository.CategoriaRepository;
import com.sistemas.app.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
    private ProductoService productoService;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

    @GetMapping("/registraprod")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "productoregistro"; 
    }

    @PostMapping("/registraprod")
    public String registrarProducto(@ModelAttribute Producto producto) {
        productoService.registrarProducto(producto);
        return "redirect:/productos/lista";
    }

    @GetMapping("/lista")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "lista"; 
    }
}
