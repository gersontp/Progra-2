package usmp.pe.edu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import usmp.pe.edu.bean.Producto;
import usmp.pe.edu.bean.ProductoRepository;

@Controller
public class AddProductoController {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	
	@GetMapping("/agregarProducto")
	public String loadFormProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "productoForm";
	}

	@PostMapping("/agregarProducto")
	public String submitProducto(@ModelAttribute Producto producto) {
		
		System.out.println("Codigo :: " + producto.getCodigo());
		productoRepo.save(producto);

		return "inicio";
		
	}
	
	@GetMapping(value = "/producto/{productId}/eliminar")
	public String eliminarPerson(@PathVariable("productId") long codigo,
			Model model) {
		System.out.println("Codigo : " + codigo);
		productoRepo.delete(codigo);
		return "inicio";
	}

	@GetMapping("/listarProductos")
	public String list(Map<String, Object> model) {
		List<Producto> productos = productoRepo.findAll();
		model.put("productos", productos);
		return "listaProductos";
	}
	
	@GetMapping(value = "/producto/{productId}/edit")
	public String editPerson(@PathVariable("productId") long codigo,
			Model model) {
		Producto producto = productoRepo.findOne(codigo);
		System.out.println("Codigo de Edit " + producto.getCodigo());
		model.addAttribute("producto", producto);
		return "productoForm";
	}
	
}
