package integrador2.factory;

import javax.persistence.EntityManagerFactory;

import integrador2.repository.*;

public interface RepositoryFactory {
	
	public EstudianteRepository getEstudianteRepository(EntityManagerFactory emf);
	
	public EstudianteCarreraRepository getEstudianteCarreraRepository(EntityManagerFactory emf);
	
	public CarreraRepository getCarreraRepository(EntityManagerFactory emf);
	
}
