package integrador2.csv;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import integrador2.repository.Repository;


public class CSVReader {
	private static CSVReader instancia;
	
	private CSVReader(){}
    
    public static CSVReader getInstance(){
        if(instancia == null){
            instancia = new CSVReader();
        }
        return instancia;
    }
    
    @SuppressWarnings("deprecation")
	public void insertar(String path, Repository<?> r){
        CSVParser parser = null;

        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (CSVRecord row : parser){
            r.insertar(row);
        }
    }
}
