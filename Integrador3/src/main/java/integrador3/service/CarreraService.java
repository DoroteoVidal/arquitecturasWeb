package integrador3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import integrador3.model.Carrera;

import integrador3.dto.CarreraDTO;
import integrador3.dto.ReporteDTO;
import integrador3.repository.CarreraRepository;
import jakarta.transaction.Transactional;

@Service("CarreraService")
public class CarreraService {
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Transactional
    public Carrera save(Carrera carrera) throws Exception {
        try{
            return carreraRepository.save(carrera);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos() throws Exception { 
		var result = carreraRepository.obtenerCarrerasConEstudiantesInscriptos();
		try{
			return result.stream().map(c -> new CarreraDTO((String)c[0], (Long)c[1]))
			.collect(Collectors.toList());
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<ReporteDTO> obtenerReportes() throws Exception { 
		var result = carreraRepository.obtenerReportes();
		try{
			return result.stream().map(c -> new ReporteDTO((String)c[0], (Long)c[1], (Long)c[2], (Long)c[3]))
			.collect(Collectors.toList());
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
}
