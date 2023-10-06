package integrador3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import integrador3.dto.InscripcionDTO;
import integrador3.model.Carrera;
import integrador3.model.Estudiante;
import integrador3.model.Inscripcion;
import integrador3.repository.CarreraRepository;
import integrador3.repository.EstudianteRepository;
import integrador3.repository.InscripcionRepository;

@Service
public class InscripcionService {
	
    @Autowired
    private InscripcionRepository inscripcionRepository;
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    @Autowired
    private CarreraRepository carreraRepository;

    @Transactional
    public InscripcionDTO save(InscripcionDTO dto) throws Exception {	
    	Estudiante estudiante = estudianteRepository.buscarPorDni(dto.getDniEstudiante()).get();
		Carrera carrera = carreraRepository.buscarPorId(dto.getIdCarrera()).get();
    	Inscripcion inscripcion = new Inscripcion(estudiante, carrera, dto.getFechaInscripcion(), dto.getFechaGraduacion(), dto.getAntiguedad());
        try{
            if (inscripcionRepository.save(inscripcion) != null) {
            	return dto;
            }
            return null;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
}
