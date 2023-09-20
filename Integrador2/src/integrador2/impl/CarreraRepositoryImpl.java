package integrador2.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.csv.CSVRecord;

import integrador2.dto.CarreraDTO;
import integrador2.entidades.Carrera;
import integrador2.repository.CarreraRepository;

public class CarreraRepositoryImpl implements CarreraRepository{
	
	private EntityManagerFactory emf;
	
	public CarreraRepositoryImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos() {
		List<Carrera> lista = new ArrayList<>();
		List<CarreraDTO> listaDto = new ArrayList<>();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		lista = em.createQuery("SELECT c "
				+ "FROM Carrera c "
				+ "JOIN c.estudiantes e "
				+ "WHERE c.id = e.carrera.id "
				+ "GROUP BY c "
				+ "ORDER BY COUNT(c) DESC").getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		if(lista.size() > 0) {
			for(Carrera c : lista) {
				CarreraDTO dto = new CarreraDTO(c.getId(), c.getNombre(), c.getDuracion());
				listaDto.add(dto);
			}
		}
		
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
