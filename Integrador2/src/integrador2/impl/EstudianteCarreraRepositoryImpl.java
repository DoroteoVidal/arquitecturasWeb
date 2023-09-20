package integrador2.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.csv.CSVRecord;

import integrador2.entidades.Carrera;
import integrador2.entidades.Estudiante;
import integrador2.entidades.EstudianteCarrera;
import integrador2.repository.EstudianteCarreraRepository;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
	
	private EntityManagerFactory emf;
	
	public EstudianteCarreraRepositoryImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void insertar(CSVRecord row) {
		Estudiante e;
		Carrera c;
		Long id_estudiante = Long.valueOf(row.get("id_estudiante"));
		Long id_carrera = Long.valueOf(row.get("id_carrera"));
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		e = em.createQuery("SELECT e FROM Estudiante e WHERE e.id = :ide", Estudiante.class)
		.setParameter("ide", id_estudiante).getSingleResult();
		
		c = em.createQuery("SELECT c FROM Carrera c WHERE c.id = :idc", Carrera.class)
		.setParameter("idc", id_carrera).getSingleResult();
		
		em.getTransaction().commit();
		em.close();
		
		EstudianteCarrera ec = new EstudianteCarrera(e, c, Long.valueOf(row.get("inscripcion")), 
		Long.valueOf(row.get("graduacion")), Integer.valueOf(row.get("antiguedad")));
		
		this.crear(ec);
	}

	@Override
	public void crear(EstudianteCarrera r) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		if(!em.contains(r)) {
			em.persist(r);
		} else {
			em.merge(r);
		}
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public EstudianteCarrera obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstudianteCarrera> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(EstudianteCarrera r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
