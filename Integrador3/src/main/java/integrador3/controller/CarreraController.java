package integrador3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.service.CarreraService;

@RestController
@RequestMapping("carreras")
public class CarreraController {
	
	@Autowired
	private CarreraService carreraService;
		
}
