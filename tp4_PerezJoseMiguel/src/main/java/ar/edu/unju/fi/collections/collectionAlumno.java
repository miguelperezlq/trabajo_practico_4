package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class collectionAlumno {
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> getAlumnos(){
		if(alumnos.isEmpty()) {
			//alumnos.add(new Alumno(1,""))
		}
		return alumnos;
		
	}

}
