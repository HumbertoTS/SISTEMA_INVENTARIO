package com.sistemas.app.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
=======
import org.springframework.security.core.Authentication;
>>>>>>> f369ea648191a54e26d230dc64584fc589671334
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< HEAD

import com.sistemas.app.model.Categoria;
import com.sistemas.app.model.Producto;
import com.sistemas.app.repository.CategoriaRepository;
import com.sistemas.app.repository.ProductoRepository;
import com.sistemas.app.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
    private ProductoService productoService;
	
	@Autowired
    private ProductoRepository productoRepository;
	
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
    public String listarProductos(@RequestParam(value = "keyword", required = false) String keyword,Model model) {
    	List<Producto> productos;
        if (keyword != null && !keyword.isEmpty()) {            
            productos = productoRepository.findByCodigoProductoContainingIgnoreCaseOrNombreContainingIgnoreCase(keyword, keyword);
        } else {
            productos = productoRepository.findAll();
        }
    	model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("keyword", keyword);
        return "productolistar";       
    }
     
    @PostMapping("/actualizar")
    public String actualizarProducto(@ModelAttribute Producto producto) {        
    	if (producto.getCategoria() != null && producto.getCategoria().getIdCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(producto.getCategoria().getIdCategoria())
                    .orElse(null);
            producto.setCategoria(categoria);
    	}
    	productoRepository.save(producto);
        return "redirect:/productos/lista";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarProducto(@PathVariable("codigo") String codigoProducto) {
        productoRepository.deleteById(codigoProducto);
        return "redirect:/productos/lista";
    }
=======
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistemas.app.dto.ProductoDTO;
import com.sistemas.app.service.CategoriaService;
import com.sistemas.app.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @GetMapping("/listar")
    public String mostrarLista(Authentication authentication,Model model) {

        model.addAttribute("usuario",authentication.getName());

        model.addAttribute("productos", productoService.getAllProductos());

        model.addAttribute("categorias", categoriaService.getAllCategorias());

        return "producto-listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("producto", new ProductoDTO());

        model.addAttribute("categorias", categoriaService.getAllCategorias());

        return "producto-agregar";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO productoDTO) {

        productoService.createProducto(productoDTO);

        return "redirect:listar?success";
    }

    @GetMapping("/editar/{codigoProducto}")
    public String editarProducto(
            @PathVariable String codigoProducto,
            Model model) {

        ProductoDTO producto = productoService.getProductoByCodigo(codigoProducto);

        model.addAttribute("producto", producto);

        model.addAttribute("categorias", categoriaService.getAllCategorias());

        return "producto-editar";
    }

    @PostMapping("/editar")
    public String actualizarProducto(
            @ModelAttribute ProductoDTO productoDTO) {

        productoService.updateProducto(productoDTO);

        return "redirect:listar?success";
    }

    @GetMapping("/eliminar/{codigoProducto}")
    public String eliminarProducto(
            @PathVariable String codigoProducto,
            RedirectAttributes redirectAttributes) {

        productoService.deleteProducto(codigoProducto);

        redirectAttributes.addFlashAttribute("success", "Producto eliminado correctamente");
        return "redirect:/producto/listar";
    }

    @GetMapping("/buscar")
    public String buscarProducto(@RequestParam(required = false) String texto, Model model) {

        model.addAttribute("productos", productoService.buscarProductos(texto));

        return "producto-listar :: tabla-productos";
    }

>>>>>>> f369ea648191a54e26d230dc64584fc589671334
}
