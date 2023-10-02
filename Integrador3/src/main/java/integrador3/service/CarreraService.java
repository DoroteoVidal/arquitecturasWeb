package integrador3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import integrador3.dto.CarreraDTO;
import integrador3.model.Carrera;
import integrador3.repository.CarreraRepository;

@Service("CarreraService")
public class CarreraService {
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Transactional
    public Carrera save(Carrera entity) throws Exception {
		try{
            return carreraRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos() throws Exception { 
		var result = carreraRepository.obtenerCarrerasConEstudiantesInscriptos();
    	try{
            return result.stream().map(p -> new CarreraDTO(p.getNombre(), p.getCantidad()))
            .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
