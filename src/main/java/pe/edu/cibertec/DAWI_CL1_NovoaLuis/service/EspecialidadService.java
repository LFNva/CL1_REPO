package pe.edu.cibertec.DAWI_CL1_NovoaLuis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.DAWI_CL1_NovoaLuis.model.bd.Especialidad;
import pe.edu.cibertec.DAWI_CL1_NovoaLuis.repository.EspecialidadRepository;

@Service
public class EspecialidadService {
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	public List<Especialidad> listado(){
		return especialidadRepository.findAll();
	}
	public void Registrar(Especialidad especialidad) {
		especialidadRepository.save(especialidad);
	}
}
