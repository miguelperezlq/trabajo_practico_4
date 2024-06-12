package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class collectionCarrera {
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	
	/* Devulve un arrayList de objetos de la clase carrera */
	public static List<Carrera> getCarreras(){
		if(carreras.isEmpty()) {
			carreras.add(new Carrera(1,"APU",3,true));
			carreras.add(new Carrera(2,"Ingenieria Informatica",5,true));
			carreras.add(new Carrera(3,"Ingenieria Industrial",5,false));
		}
		return carreras;
	}
	
	/*Agrega un objeto Carrera al arrayList de carreras*/
	public static void agregarCarrera(Carrera carrera) {
		carreras.add(carrera);
	}
	
	/*Elimina un objeto carrera del arrayList de carreras*/
	public static void eliminarCarrera(int codigoCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo() == codigoCarrera) {
				iterator.remove();
			}
		}
	}
	
	/*Modifica un objeto carrera con los nuevos valores enviados*/
	public static void modificarCarrera(Carrera carrera) {
		for(Carrera carre : carreras) {
			if(carre.getCodigo() == carrera.getCodigo()) {
				carre.setNombre(carrera.getNombre());
				carre.setCantidadAnios(carrera.getCantidadAnios());
				carre.setEstado(carrera.isEstado());
			}else {
				System.out.println("no se encuentra el codigo de carrera");
			}
		}
	}
	
	/*Busca un objeto carrera dentro del arrayList*/
	public static Carrera buscarCarrera(int codigo) {
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		if(carrera.isPresent()) {
			return carrera.get();
		}else {
			return null;
		}
	}

}
