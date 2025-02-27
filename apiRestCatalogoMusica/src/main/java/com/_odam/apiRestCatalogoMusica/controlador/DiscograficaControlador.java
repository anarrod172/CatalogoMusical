package com._odam.apiRestCatalogoMusica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com._odam.apiRestCatalogoMusica.excepciones.DiscograficaNotFound;
import com._odam.apiRestCatalogoMusica.modelos.Discografica;
import com._odam.apiRestCatalogoMusica.servicios.DiscograficaServicioImpl;


@Controller
@RequestMapping("/discografica")
public class DiscograficaControlador {
	
	//Inyectamos el servicio
	@Autowired
	private DiscograficaServicioImpl discograficaServicio;
	
	
	//Servicios que devuelven un html
	@RequestMapping("/listaDiscografica")
	public String catalogoDiscografica(Model model) {
		List<Discografica> discograficas = discograficaServicio.mostrarListaDiscografica();
		System.out.println(discograficas);
		model.addAttribute("discograficas", discograficas);
		return "listaDiscografica";
	}
	
	@RequestMapping("/listaDiscograficaNombre/{nombre}")
	public String catalogoDiscograficaNombre(@PathVariable String nombre, Model model) {
		List<Discografica> discograficas = discograficaServicio.filtrarDiscograficaPorNombre(nombre);
		System.out.println(discograficas);
		model.addAttribute("discograficas", discograficas);
		return "listaDiscograficaNombre";
	}
	
	
	//Servicios que de devuelven un Json
	@GetMapping("/{idDiscografica}")
	@ResponseBody
	public ResponseEntity<Discografica> obtenerDiscograficaId(@PathVariable Integer idDiscografica) throws DiscograficaNotFound{
		Discografica discografica = discograficaServicio.mostrarDiscografica(idDiscografica);
		return ResponseEntity.ok(discografica);
	}
	
	@PostMapping("/altaDiscografica")
	@ResponseBody
	public ResponseEntity<Discografica> anyadirDiscografica(@RequestBody Discografica discografica)  {
		Discografica discograficaAnyadida = discograficaServicio.altaDiscografica(discografica);
		return new ResponseEntity<>(discograficaAnyadida, HttpStatus.CREATED);
	}
	
	@PutMapping("/{idDiscografica}/{telefono}")
	@ResponseBody
	public ResponseEntity<Discografica> actualizarDiscografica(@PathVariable Integer idDiscografica, @PathVariable String telefono) throws DiscograficaNotFound{
         return new ResponseEntity<>(discograficaServicio.actualizarTelefono(idDiscografica, telefono), HttpStatus.OK);
    }
	
	
	//Control de excepciones por web
	@ExceptionHandler(DiscograficaNotFound.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(DiscograficaNotFound exception) {
			Response response = Response.errorResponse(Response.NOT_FOUND, exception.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
}
