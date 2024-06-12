package ar.edu.unju.fi.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.collectionCarrera;
import ar.edu.unju.fi.collections.collectionDocente;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteControler {
	
	@Autowired
	private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		model.addAttribute("docentes", collectionDocente.getDocentes());
		model.addAttribute("titulo", "Docentes");
		return "docenteList";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		boolean edicion = false;
		model.addAttribute("docente", docente);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo","Nueva Docente");
		return "docenteForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
		ModelAndView modelView = new ModelAndView("docenteList");
		//carrera.setEstado(true);
		collectionDocente.agregarDocente(docente);
		modelView.addObject("docentes",collectionDocente.getDocentes());
		
		
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="legajo") int codigo) {
		Docente docenteEncontrada = new Docente();
		boolean edicion = true;
		docenteEncontrada = collectionDocente.buscarDocente(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontrada);
		model.addAttribute("titulo","Modificar Docente");
		return "docenteForm";
		
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") Docente docente) {
		collectionDocente.modificarDocente(docente);
		return "redirect:/docente/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") int codigo) {
		collectionDocente.eliminarDocente(codigo);
		return "redirect:/docente/listado";
	}
	
	
	
}
