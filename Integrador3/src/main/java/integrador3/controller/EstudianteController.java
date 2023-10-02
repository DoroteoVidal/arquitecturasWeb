package integrador3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.service.EstudianteService;

@RestController
@RequestMapping("estudiantes")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("/ordenadosPorApellido")
	public ResponseEntity<?> obtenerEstudiantesOrdenadosPorApellido() {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantesOrdenadosPorApellido());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
	}
	
	@GetMapping("/porLibretaUni/{libreta}")
	public ResponseEntity<?> obtenerEstudiantePorLibUni(@PathVariable Long libreta) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantePorLibUni(libreta));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
	}

}
