package integrador3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.model.Carrera;

import integrador3.service.CarreraService;

@RestController
@RequestMapping("carreras")
public class CarreraController {
	
	@Autowired
	private CarreraService carreraService;
	
	@PostMapping("")
    public ResponseEntity<?> save(@RequestBody Carrera carrera) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.save(carrera));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }
	
	@GetMapping("/conEstudiantesInscriptos")
	public ResponseEntity<?> obtenerCarrerasConEstudiantesInscriptos() {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(carreraService.obtenerCarrerasConEstudiantesInscriptos());
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}
	
	@GetMapping("/reportes")
	public ResponseEntity<?> obtenerReportes() {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(carreraService.obtenerReportes());
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}
		
}
