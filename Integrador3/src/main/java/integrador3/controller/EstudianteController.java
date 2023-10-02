package integrador3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.model.Estudiante;
import integrador3.service.EstudianteService;

@RestController
@RequestMapping("estudiantes")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){ 
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el objeto buscado.\"}");
        }
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Estudiante entity) { 
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
	}
	
	@GetMapping("/ordenadosPorApellido")
	public ResponseEntity<?> obtenerEstudiantesOrdenadosPorApellido() {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantesOrdenadosPorApellido());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
	}
	
	@GetMapping("/PorLibretaUni/{libreta}")
	public ResponseEntity<?> obtenerEstudiantePorLibUni(@PathVariable Long libreta) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantePorLibUni(libreta));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
	}
	
	@GetMapping("/PorGenero/{genero}")
	public ResponseEntity<?> obtenerEstudiantePorGenero(@PathVariable String genero) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantePorGenero(genero));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
	}
	
	@GetMapping("/PorCarreraYCiudad/{idCarrera}/{ciudad}")
	public ResponseEntity<?> obtenerEstudiantesDeCarreraPorCiudad(@PathVariable Long idCarrera, @PathVariable String ciudad) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantesDeCarreraPorCiudad(idCarrera, ciudad));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
	}
}
