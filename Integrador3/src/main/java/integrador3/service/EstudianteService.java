package integrador3.service;

import java.util.List;
import java.util.Optional;
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
	/*
	@Transactional
    public List<Estudiante> findAll() throws Exception {
        return estudianteRepository.findAll();
    }
	
	@Transactional
    public Estudiante findById(Long id) throws Exception {
		try{
            Optional<Estudiante> person = estudianteRepository.findById(id);
            return person.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	*/
	@Transactional
    public Estudiante save(Estudiante entity) throws Exception {
		try{
            return estudianteRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public List<EstudianteDTO> findAllBySurname(String surname) throws Exception { 
		var result = estudianteRepository.findAllBySurname(surname);
    	try{
            return result.stream().map(p -> new EstudianteDTO(p.getDni(), p.getNombre(), 
            p.getApellido(), p.getEdad(), p.getGenero(), p.getCiudadResidencia(), p.getNumLibretaUni()))
            .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public EstudianteDTO findByNumLibreta(Long lu) throws Exception {
		try {
			Optional<EstudianteDTO> estudiante = estudianteRepository.findByNumLibreta(lu);
            return estudiante.get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public List<EstudianteDTO> findAllByGenero(String genero) throws Exception { 
		var result = estudianteRepository.findAllByGenero(genero);
    	try{
            return result.stream().map(p -> new EstudianteDTO(p.getDni(), p.getNombre(), 
            p.getApellido(), p.getEdad(), p.getGenero(), p.getCiudadResidencia(), p.getNumLibretaUni()))
            .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
