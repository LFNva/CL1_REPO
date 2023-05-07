package pe.edu.cibertec.DAWI_CL1_NovoaLuis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.DAWI_CL1_NovoaLuis.service.EspecialidadService;

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping("/frmListEspecialidad")
	public String frmMantEstado(Model model) {
		model.addAttribute("listaEsp", especialidadService.listado());
		return "Especialidad/frmListEspecialidad";
	}
}
