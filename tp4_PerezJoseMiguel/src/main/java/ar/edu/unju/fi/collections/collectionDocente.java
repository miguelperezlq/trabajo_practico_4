package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;

@Component
public class collectionDocente {
private static List<Docente> docentes = new ArrayList<Docente>();
	
	
	/* Devulve un arrayList de objetos de la clase docente */
	public static List<Docente> getDocentes(){
		if(docentes.isEmpty()) {
			docentes.add(new Docente(1,"Miguel","Perez","miguel.mp313@gmail.com","3885405580"));
			docentes.add(new Docente(2,"Clarisa","Burgos","clarisa@gmail.com","3885121212"));
			docentes.add(new Docente(3,"Noelia","Calatayud","noelia@gmail.com","3885405580"));
		}
		return docentes;
	}
	
	/*Agrega un objeto docente al arrayList de docentes*/
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	/*Elimina un objeto docente del arrayList de docentes*/
	public static void eliminarDocente(int legajoDocente) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLegajo() == legajoDocente) {
				iterator.remove();
			}
		}
	}
	
	/*Modifica un objeto docente con los nuevos valores enviados*/
	public static void modificarDocente(Docente docente) {
		for(Docente carre : docentes) {
			if(carre.getLegajo() == docente.getLegajo()) {
				carre.setNombre(docente.getNombre());
				carre.setApellido(docente.getApellido());
				carre.setEmail(docente.getEmail());
				carre.setTelefono(docente.getTelefono());
			}else {
				System.out.println("no se encuentra el codigo de carrera");
			}
		}
	}
	
	/*Busca un objeto docente dentro del arrayList*/
	public static Docente buscarDocente(int codigo) {
		Predicate<Docente> filterCodigo = c -> c.getLegajo() == codigo;
		Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
		if(docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}
	}

}
