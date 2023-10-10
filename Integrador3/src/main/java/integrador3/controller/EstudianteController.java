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
	
	@PostMapping("")
    public ResponseEntity<?> save(@RequestBody Estudiante estudiante) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.save(estudiante));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el Estudiante, revise los campos e intente nuevamente.\"}");
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
	
	@GetMapping("/porNroLibreta/{libreta}")
	public ResponseEntity<?> obtenerEstudiantePorNroLibreta(@PathVariable Long libreta) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantePorNroLibreta(libreta));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe Estudiante con el numero de libreta ingresado, revise el campo e intente nuevamente.\"}");
        }
	}
	
	@GetMapping("/porGenero/{genero}")
	public ResponseEntity<?> obtenerEstudiantePorGenero(@PathVariable String genero) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantePorGenero(genero));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No hay Estudiantes con el tipo de genero ingresado, revise el campo e intente nuevamente.\"}");
		}
	}

	@GetMapping("/deCarreraPorCiudad/{idCarrera}/{ciudad}")
	public ResponseEntity<?> obtenerEstudiantesDeCarreraPorCiudad(@PathVariable Long idCarrera, @PathVariable String ciudad) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(estudianteService.obtenerEstudiantesDeCarreraPorCiudad(idCarrera, ciudad));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No hay Estudiantes que cumplan con la solicitud, revise los campos e intente nuevamente.\"}");
		}
	}
	
}
