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

import com._odam.apiRestCatalogoMusica.excepciones.AlbumNotFound;
import com._odam.apiRestCatalogoMusica.modelos.Album;
import com._odam.apiRestCatalogoMusica.servicios.AlbumServicioImpl;

@Controller
@RequestMapping("/album")
public class AlbumControlador {
	
	//Inyectamos el servicio
	@Autowired
	private AlbumServicioImpl albumServicio;
	
	
	//Servicios que devuelven un html
	@RequestMapping("/listaAlbum")
	public String catalogoAlbum(Model model) {
		List<Album> albumes = albumServicio.mostrarAlbumes();
		System.out.println(albumes);
		model.addAttribute("albumes", albumes);
		return "listaAlbum";
	}
	
	@RequestMapping("/listaAlbumAnyo/{anyoLanzamiento}")
	public String catalogoAlbumAnyo(@PathVariable Integer anyo, Model model) {
		List<Album> albumes = albumServicio.filtrarAlbumPorAnyoLanzamiento(anyo);
		System.out.println(albumes);
		model.addAttribute("albumes", albumes);
		return "listaAlbumAnyo";
	}
	
	
	//Servicios que de devuelven un Json
	@GetMapping("/albumTitulo/{nombre}")
	@ResponseBody
	public ResponseEntity<Album> obtenerAlbum(@PathVariable String nombre){
		Album album = albumServicio.mostrarAlbum(nombre);
		return ResponseEntity.ok(album);
	}
	
	@PostMapping("/altaAlbum")
	@ResponseBody
	public ResponseEntity<Album> anyadirAlbum(@RequestBody Album album) {
		Album albumAnyadido = albumServicio.altaAlbum(album);
		return new ResponseEntity<>(albumAnyadido, HttpStatus.CREATED);
	}
	
	@PutMapping("/{idCodigo}/{nombre}")
	@ResponseBody
	public ResponseEntity<Album> actualizarAlbum(@PathVariable Integer idCodigo, @PathVariable String nombre) throws AlbumNotFound{
            return new ResponseEntity<>(albumServicio.actualizarNombre(idCodigo, nombre), HttpStatus.OK);
    }
	
	//Control de excepciones por web
	@ExceptionHandler(AlbumNotFound.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(AlbumNotFound exception) {
			Response response = Response.errorResponse(Response.NOT_FOUND, exception.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
}
