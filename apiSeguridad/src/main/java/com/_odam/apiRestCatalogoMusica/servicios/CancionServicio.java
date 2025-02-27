package com._odam.apiRestCatalogoMusica.servicios;

import java.util.List;

import com._odam.apiRestCatalogoMusica.dtos.CancionDto;
import com._odam.apiRestCatalogoMusica.modelos.Cancion;

public interface CancionServicio {

	Cancion altaCancion(CancionDto cancion);
	List<Cancion> mostrarCanciones();
	Cancion mostrarCancion(String nombre);
	Cancion actualizarDuracion(Integer idCancion, Integer duracion);
	List<Cancion> filtrarCancionPorTitulo(String titulo);
}
