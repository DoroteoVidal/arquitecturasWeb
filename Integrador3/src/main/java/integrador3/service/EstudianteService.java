package integrador3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import integrador3.dto.EstudianteDTO;
import integrador3.model.Estudiante;
import integrador3.repository.EstudianteRepository;

@Service("EstudianteService")
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Transactional
    public Estudiante save(Estudiante estudiante) throws Exception {
        try{
            return estudianteRepository.save(estudiante);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public List<EstudianteDTO> obtenerEstudiantesOrdenadosPorApellido() throws Exception { 
		var result = estudianteRepository.obtenerEstudiantesOrdenadosPorApellido();
    	try{
            return result.stream().map(p -> new EstudianteDTO(p.getDni(), p.getNombre(), 
            p.getApellido(), p.getEdad(), p.getGenero(), p.getCiudadResidencia(), p.getNumLibretaUni()))
            .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public EstudianteDTO obtenerEstudiantePorNroLibreta(Long lu) throws Exception {
		try {
			Estudiante e = estudianteRepository.obtenerEstudiantePorNroLibreta(lu);
            return new EstudianteDTO(e.getDni(), e.getNombre(), e.getApellido(),e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumLibretaUni());
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public List<EstudianteDTO> obtenerEstudiantePorGenero(String genero) throws Exception { 
		var result = estudianteRepository.obtenerEstudiantePorGenero(genero);
		try{
			return result.stream().map(p -> new EstudianteDTO(p.getDni(), p.getNombre(), 
			p.getApellido(), p.getEdad(), p.getGenero(), p.getCiudadResidencia(), p.getNumLibretaUni()))
			.collect(Collectors.toList());
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
		
	@Transactional
	public List<EstudianteDTO> obtenerEstudiantesDeCarreraPorCiudad(Long idCarrera, String ciudad) throws Exception {
		var result = estudianteRepository.obtenerEstudiantesDeCarreraPorCiudad(idCarrera, ciudad);
		try{
			return result.stream().map(p -> new EstudianteDTO(p.getDni(), p.getNombre(), 
			p.getApellido(), p.getEdad(), p.getGenero(), p.getCiudadResidencia(), p.getNumLibretaUni()))
			.collect(Collectors.toList());
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
}
