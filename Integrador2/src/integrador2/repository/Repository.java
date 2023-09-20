package integrador2.repository;

import java.util.List;

import org.apache.commons.csv.CSVRecord;

public interface Repository<T> {
	
	public void insertar(CSVRecord row);
	
	public void crear(T t);
	
	public T obtenerPorId(Long id);
	
	public List<T> obtenerTodos();
	
	public void modificar(T e);
	
	public void eliminar(Long id);	
}
