package integrador3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import integrador3.repository.CarreraRepository;

@Service("CarreraService")
public class CarreraService {
	
	@Autowired
	private CarreraRepository carreraRepository;
	
}
