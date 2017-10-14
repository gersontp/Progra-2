package usmp.pe.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import usmp.pe.edu.bean.Usuario;

@Controller
public class AddUsuarioController {
	
	@GetMapping("/acceder")
	public String loadFormUsuario(Model model) {
//		model.addAttribute("producto", new Producto());
		System.out.println("Acceder GET Usuario");
		return "inicio";
	}
	
	@PostMapping("/acceder")
	public String submitUsuario(@ModelAttribute Usuario usuario) {

//		productoRepo.save(producto);
		System.out.println("Acceder Post Usuario");
		return "inicio";
		
	}
}
