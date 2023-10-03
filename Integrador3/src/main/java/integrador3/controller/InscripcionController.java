package integrador3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.model.Inscripcion;
import integrador3.service.InscripcionService;

@RestController
@RequestMapping("inscripciones")
public class InscripcionController {
	
	@Autowired
    private InscripcionService inscripcionService;
	
	@PostMapping("")
    public ResponseEntity<?> save(@RequestBody Inscripcion inscripcion){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.save(inscripcion));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }

}
