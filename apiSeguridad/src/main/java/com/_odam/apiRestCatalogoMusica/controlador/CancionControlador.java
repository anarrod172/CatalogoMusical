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

import com._odam.apiRestCatalogoMusica.dtos.CancionDto;
import com._odam.apiRestCatalogoMusica.excepciones.CancionNotFound;
import com._odam.apiRestCatalogoMusica.modelos.Cancion;
import com._odam.apiRestCatalogoMusica.servicios.CancionServicioImpl;


@Controller
@RequestMapping("/cancion")
public class CancionControlador {
	
	//Inyectamos el servicio
	@Autowired
	private CancionServicioImpl cancionServicio;
	
	//Servicios que devuelven un html
	@RequestMapping("/listaCancion")
	public String catalogoCanciones(Model model) {
		List<Cancion> canciones = cancionServicio.mostrarCanciones();
		System.out.println(canciones);
		model.addAttribute("canciones", canciones);
		return "listaCancion";
	}
	
	@RequestMapping("/listaCancionTitulo/{titulo}")
	public String catalogoCancionesTitulo(@PathVariable String titulo, Model model) {
		List<Cancion> canciones = cancionServicio.filtrarCancionPorTitulo(titulo);
		System.out.println(canciones);
		model.addAttribute("discograficas", canciones);
		return "listaCancionTitulo";
	}
	
	//Servicios que de devuelven un Json
	@GetMapping("/cancionTitulo/{titulo}")
	@ResponseBody
	public ResponseEntity<Cancion> obtenerCancion(@PathVariable String titulo){
		Cancion cancion = cancionServicio.mostrarCancion(titulo);
		return ResponseEntity.ok(cancion);
	}
	
	@PostMapping("/altaCancion")
	@ResponseBody
	public ResponseEntity<Cancion> anyadirCancion(@RequestBody CancionDto cancion) throws CancionNotFound {
		Cancion cancionAnyadida = cancionServicio.altaCancion(cancion);
		return new ResponseEntity<>(cancionAnyadida, HttpStatus.CREATED);
	}
		
	@PutMapping("/{idCancion}/{duracion}")
	@ResponseBody
	public ResponseEntity<Cancion> actualizarCancion(@PathVariable Integer idCancion, @PathVariable Integer duracion) throws CancionNotFound{
            return new ResponseEntity<>(cancionServicio.actualizarDuracion(idCancion, duracion), HttpStatus.OK);
    }
	
	//Control de excepciones por web
	@ExceptionHandler(CancionNotFound.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(CancionNotFound exception) {
			Response response = Response.errorResponse(Response.NOT_FOUND, exception.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
}
