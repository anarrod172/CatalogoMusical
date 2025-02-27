package com._odam.apiRestCatalogoMusica.servicios;

import java.util.List;

import com._odam.apiRestCatalogoMusica.modelos.Album;


public interface AlbumServicio {
	
	Album altaAlbum(Album album);
	List<Album> mostrarAlbumes();
	Album mostrarAlbum(String nombre);
	Album actualizarNombre(Integer idAlbum, String Nombre);
	List<Album> filtrarAlbumPorAnyoLanzamiento(Integer anyoLanzamiento);
}
