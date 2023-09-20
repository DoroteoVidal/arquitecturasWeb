package integrador2.factory;

import javax.persistence.EntityManagerFactory;

import integrador2.repository.*;
import integrador2.impl.*;

public class RepositoryFactoryImpl implements RepositoryFactory {
	
	private static RepositoryFactoryImpl instancia;
    
    private RepositoryFactoryImpl(){}
    
    public static RepositoryFactoryImpl getInstance(){
        if(instancia == null){
            instancia = new RepositoryFactoryImpl();
        }
        return instancia;
    }

	@Override
	public EstudianteRepository getEstudianteRepository(EntityManagerFactory emf) {
		return new EstudianteRepositoryImpl(emf);
	}

	@Override
	public EstudianteCarreraRepository getEstudianteCarreraRepository(EntityManagerFactory emf) {
		return new EstudianteCarreraRepositoryImpl(emf);
	}

	@Override
	public CarreraRepository getCarreraRepository(EntityManagerFactory emf) {
		return new CarreraRepositoryImpl(emf);
	}

}
