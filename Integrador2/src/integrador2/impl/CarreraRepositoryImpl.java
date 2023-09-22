package integrador2.impl;

import java.math.BigInteger;
import java.util.ArrayList;
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
		
		String sql = "SELECT c.nombre, ec.fecha_inscripcion, COUNT(ec.fecha_inscripcion) as cant_inscriptos, COUNT(CASE WHEN ec.fecha_graduacion != 0 THEN 1 END ) as graduados "
		+ "FROM carrera c JOIN estudiantecarrera ec ON (c.id = ec.fk_carrera) "
		+ "GROUP BY c.nombre, ec.fecha_inscripcion "
		+ "ORDER BY ec.fecha_inscripcion ASC";
		
		lista = em.createNativeQuery(sql).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		List<ReporteDTO> reporte = lista.stream().map(o -> new ReporteDTO((String)o[0], (BigInteger)o[1], (BigInteger)o[2], (BigInteger)o[3])).toList();
		return reporte;
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
				+ "ON (c.id = e.carrera.id) "
				+ "GROUP BY c.id "
				+ "ORDER BY count(*) DESC").getResultList();
		
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
