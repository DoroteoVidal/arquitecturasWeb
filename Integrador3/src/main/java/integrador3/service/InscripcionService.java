package integrador3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import integrador3.model.Inscripcion;
import integrador3.repository.InscripcionRepository;

@Service
public class InscripcionService {
	
    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Transactional
    public Inscripcion save(Inscripcion inscripcion) throws Exception {
        try{
            return inscripcionRepository.save(inscripcion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
}
