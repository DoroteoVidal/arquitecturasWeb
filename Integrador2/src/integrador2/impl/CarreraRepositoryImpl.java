package integrador2.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.csv.CSVRecord;

import integrador2.dto.CarreraDTO;
import integrador2.dto.ReporteDTO;
import integrador2.entidades.Carrera;
import integrador2.repository.CarreraRepository;

public class CarreraRepositoryImpl implements CarreraRepository{
	
	private EntityManagerFactory emf;
	
	public CarreraRepositoryImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteDTO> obtenerReporte() {
		List<Object[]> lista;
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		lista = em.createNativeQuery("SELECT nombre, fecha_inscripcion, COUNT(fecha_inscripcion) as inscriptos, 0 as graduados "
				+ "FROM carrera c JOIN estudiantecarrera ec ON (c.id = ec.fk_carrera) "
				+ "GROUP BY nombre, fecha_inscripcion "
				+ "UNION "
				+ "SELECT nombre, fecha_graduacion, 0 as inscriptos, COUNT(fecha_graduacion) as graduados "
				+ "FROM carrera c JOIN estudiantecarrera ec ON (c.id = ec.fk_carrera) "
				+ "GROUP BY nombre, fecha_graduacion "
				+ "HAVING fecha_graduacion != 0 "
				+ "ORDER BY nombre, fecha_inscripcion ASC").getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		List<ReporteDTO> reporte = lista.stream().map(o -> 
		new ReporteDTO((String)o[0], (BigInteger)o[1], (BigInteger)o[2], (BigInteger)o[3])).toList();
		return reporte;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos() {
		List<Object[]> lista;

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		lista = em.createQuery("SELECT c.nombre, COUNT(ec.estudiante) "
			+ "FROM Carrera c "
			+ "JOIN c.estudiantes ec ON (c.id = ec.carrera.id) "
			+ "GROUP BY c.nombre "
			+ "ORDER BY COUNT(ec.estudiante) ASC").getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		List<CarreraDTO> listaDto = lista.stream().map(c -> new CarreraDTO((String)c[0], (Long)c[1])).toList();
		
		return listaDto;
	}
	
	@Override
	public void insertar(CSVRecord row) {
		Carrera c = new Carrera(row.get("carrera"), Integer.valueOf(row.get("duracion")));
		
		this.crear(c);
	}
	
	@Override
	public void crear(Carrera c) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		if(!em.contains(c)) {
			em.persist(c);
		} else {
			em.merge(c);
		}
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Carrera obtenerPorId(Long id) {
		Carrera c;
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		c = em.createQuery("SELECT c FROM Carrera c WHERE c.id = :id", Carrera.class)
		.setParameter("id", id)
		.getSingleResult();
		
		em.getTransaction().commit();
		em.close();

		return c;
	}

	@Override
	public List<Carrera> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Carrera c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearCarrera(Carrera c) {
		// TODO Auto-generated method stub
		
	}

}
