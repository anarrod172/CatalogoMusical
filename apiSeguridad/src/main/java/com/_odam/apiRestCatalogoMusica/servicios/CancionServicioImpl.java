package com._odam.apiRestCatalogoMusica.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._odam.apiRestCatalogoMusica.dtos.CancionDto;
import com._odam.apiRestCatalogoMusica.excepciones.CancionNotFound;
import com._odam.apiRestCatalogoMusica.excepciones.DiscograficaNotFound;
import com._odam.apiRestCatalogoMusica.modelos.Album;
import com._odam.apiRestCatalogoMusica.modelos.Cancion;
import com._odam.apiRestCatalogoMusica.repositorios.AlbumRepositorio;
import com._odam.apiRestCatalogoMusica.repositorios.CancionRepositorio;



@Service
public class CancionServicioImpl implements CancionServicio {
	
	//Inyectamos el repositorio
	@Autowired
	private CancionRepositorio cancionRepo;
	
	private AlbumRepositorio albumRepo;

	//Dar de alta una canción
	@Override
	public Cancion altaCancion(CancionDto cancion) throws CancionNotFound{
		Album album = albumRepo.findById(cancion.getIdCodigo()).orElseThrow(
				()-> new DiscograficaNotFound()
				);
		Cancion cancionNueva = new Cancion();
		Cancion cancionDto = new Cancion();
		cancionDto.setIdCancion(cancion.getIdCancion());
		cancionDto.setTitulo(cancion.getTitulo());
		cancionDto.setDuracion(cancion.getDuracion());
		cancionDto.setAlbum(album);
		cancionNueva = cancionRepo.save(cancionDto);
		return cancionNueva;
	}

	//Mostrar todas las canciones
	@Override
	public List<Cancion> mostrarCanciones() {
		List<Cancion> listadoCanciones = cancionRepo.findAll();	
		List<Cancion> canciones = new ArrayList<Cancion>();
		for(Cancion cancion:listadoCanciones) {
			canciones.add(cancion);
		}
		return canciones;
	}

	//Mostrar cancion según el título
	@Override
	public Cancion mostrarCancion(String titulo) {
		Cancion cancion = cancionRepo.findByTitulo(titulo);
		return cancion;
	}

	@Override
	public Cancion actualizarDuracion(Integer idCancion, Integer duracion) throws CancionNotFound {
		Cancion cancionSinActualizar = cancionRepo.findById(idCancion).orElseThrow(
				() -> new CancionNotFound(idCancion)
				);
		cancionSinActualizar.setDuracion(duracion);
		Cancion cancionActualizada = cancionRepo.save(cancionSinActualizar);
		return cancionActualizada;
	}

	//Filtrar canción por título
	@Override
	public List<Cancion> filtrarCancionPorTitulo(String titulo) {
		return cancionRepo.findAllByTitulo(titulo);
	}

}
