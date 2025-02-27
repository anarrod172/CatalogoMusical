package com._odam.apiRestCatalogoMusica.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._odam.apiRestCatalogoMusica.excepciones.AlbumNotFound;
import com._odam.apiRestCatalogoMusica.modelos.Album;
import com._odam.apiRestCatalogoMusica.repositorios.AlbumRepositorio;


@Service
public class AlbumServicioImpl implements AlbumServicio{
	
	//Inyectar el repositorio
	@Autowired
	private AlbumRepositorio albumRepo;

	//Dar de alta un album
	@Override
	public Album altaAlbum(Album album) {
		Album albumNuevo = new Album();
		albumNuevo = albumRepo.save(album);
		return albumNuevo;
	}

	//Mostrar todos los albumes de la colección
	@Override
	public List<Album> mostrarAlbumes() {
		List<Album> listadoAlbumes = albumRepo.findAll();	
		List<Album> albumes = new ArrayList<Album>();
		for(Album album:listadoAlbumes) {
			albumes.add(album);
		}
		return albumes;
	}

	//Mostrar album según su nombre
	@Override
	public Album mostrarAlbum(String nombre) {
		Album album = albumRepo.findByNombre(nombre);
		return album;
	}

	//Mostrar el album con el nombre actualizado
	@Override
	public Album actualizarNombre(Integer idCodigo, String nombre) throws AlbumNotFound {
		Album albumSinActualizar = albumRepo.findById(idCodigo).orElseThrow(
				() -> new AlbumNotFound(idCodigo)
				);
		albumSinActualizar.setNombre(nombre);
		Album albumActualizado = albumRepo.save(albumSinActualizar);
		return albumActualizado;
	}

	//Filtrar album por su año de lanzamiento
	@Override
	public List<Album> filtrarAlbumPorAnyoLanzamiento(Integer anyoLanzamiento) {
		return albumRepo.findAllByAnyoLanzamiento(anyoLanzamiento);
	}

}
