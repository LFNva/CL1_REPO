package pe.edu.cibertec.DAWI_CL1_NovoaLuis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.DAWI_CL1_NovoaLuis.model.bd.Especialidad;
import pe.edu.cibertec.DAWI_CL1_NovoaLuis.service.EspecialidadService;

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping("/frmListEspecialidad")
	public String frmMantEspecialidad(Model model) {
		model.addAttribute("listaEsp", especialidadService.listado());
		return "Especialidad/frmListEspecialidad";
	}
	@GetMapping("/frmRegEspecialidad")
	public String frmRegEspecialidad(Model model) {
		model.addAttribute("especialidadForm", new Especialidad());
		model.addAttribute("visualizar",false);
		return "Especialidad/frmRegEspecialidad";
	}
	
	@PostMapping("/frmRegEspecialidad")
	public String registrarEspecialidad(@ModelAttribute("especialidadForm") Especialidad especialidad, Model model) {
		String mensaje = "especialida registrado correctamente";
		try {
			especialidadService.Registrar(especialidad);
		}catch(Exception e) {
			mensaje = "especialida no registrado";
		}
		model.addAttribute("especialidadForm", new Especialidad());
		model.addAttribute("visualizar",true);
		model.addAttribute("respuesta", mensaje);
		return "Especialidad/frmRegEspecialidad";
	}
}
