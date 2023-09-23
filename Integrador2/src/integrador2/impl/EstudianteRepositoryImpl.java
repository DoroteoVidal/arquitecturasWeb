package integrador2.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.csv.CSVRecord;

import integrador2.dto.EstudianteDTO;
import integrador2.entidades.Carrera;
import integrador2.entidades.Estudiante;
import integrador2.repository.EstudianteRepository;

public class EstudianteRepositoryImpl implements EstudianteRepository {
	
	private EntityManagerFactory emf;
	
	public EstudianteRepositoryImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstudianteDTO> obtenerEstudiantesDeCarreraPorCiudad(Carrera c, String ciudad) {
		List<Estudiante> lista = new ArrayList<>();
		List<EstudianteDTO> listaDto = new ArrayList<>();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		lista = em.createQuery("SELECT e FROM Estudiante e "
			+ "JOIN e.carreras ec ON (e.id = ec.estudiante.id) "
			+ "WHERE ec.carrera.id = :id_carrera "
			+ "AND e.ciudadResidencia = :ciudad")
		.setParameter("id_carrera", c.getId())
		.setParameter("ciudad", ciudad).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		if(lista.size() > 0) {
			for(Estudiante e : lista) {
				EstudianteDTO dto = new EstudianteDTO(e.getDni(), e.getNombre(), e.getApellido(), 
				e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumLibretaUni());
				listaDto.add(dto);
			}
		}
		
		return listaDto;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstudianteDTO> obtenerEstudiantePorGenero(String genero) {
		List<Estudiante> lista = new ArrayList<>();
		List<EstudianteDTO> listaDto = new ArrayList<>();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		lista = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero")
		.setParameter("genero", genero)
		.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		if(lista.size() > 0) {
			for(Estudiante e : lista) {
				EstudianteDTO dto = new EstudianteDTO(e.getDni(), e.getNombre(), e.getApellido(), 
				e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumLibretaUni());
				listaDto.add(dto);
			}
		}
		
		return listaDto;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstudianteDTO> obtenerEstudiantesPorCriterio(Comparator<EstudianteDTO> orden) {
		List<Estudiante> lista = new ArrayList<>();
		List<EstudianteDTO> listaDto = new ArrayList<>();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		lista = em.createQuery("SELECT e FROM Estudiante e").getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		if(lista.size() > 0) {
			for(Estudiante e : lista) {
				EstudianteDTO dto = new EstudianteDTO(e.getDni(), e.getNombre(), e.getApellido(), 
				e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumLibretaUni());
				listaDto.add(dto);
			}
		}
		Collections.sort(listaDto, orden);
		return listaDto;
	}

	@Override
	public EstudianteDTO obtenerEstudiantePorLibUni(Long libreta) {
		Estudiante ed = null;
		EstudianteDTO dto = null;
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		ed = em.createQuery("SELECT e FROM Estudiante e WHERE e.numLibretaUni = :libreta", Estudiante.class)
		.setParameter("libreta", libreta)
		.getSingleResult();
		
		em.getTransaction().commit();
		em.close();
		
		if(ed != null) {
			dto = new EstudianteDTO(ed.getDni(), ed.getNombre(), ed.getApellido(), 
			ed.getEdad(), ed.getGenero(), ed.getCiudadResidencia(), ed.getNumLibretaUni());
		}
		
		return dto;
	}
	
	@Override
	public void insertar(CSVRecord row) {
		Estudiante e = new Estudiante(Long.valueOf(row.get("DNI")), row.get("nombre"), row.get("apellido"), 
		Integer.valueOf(row.get("edad")), row.get("genero"), row.get("ciudad"), Long.valueOf(row.get("LU")));
		
		this.crear(e);
	}

	@Override
	public void crear(Estudiante e) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		if(!em.contains(e)) {
			em.persist(e);
		} else {
			em.merge(e);
		}
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Estudiante obtenerPorId(Long id) {
		Estudiante e;
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		e = em.createQuery("SELECT e FROM Estudiante e WHERE e.id = :id", Estudiante.class)
		.setParameter("id", id)
		.getSingleResult();
		
		em.getTransaction().commit();
		em.close();

		return e;
	}

	@Override
	public List<Estudiante> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Estudiante e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
