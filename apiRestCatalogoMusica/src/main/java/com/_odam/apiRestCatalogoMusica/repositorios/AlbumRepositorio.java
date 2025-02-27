package com._odam.apiRestCatalogoMusica.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._odam.apiRestCatalogoMusica.modelos.Album;


@Repository
public interface AlbumRepositorio extends JpaRepository<Album, Integer>{
	
	Album findByNombre(String nombre);
	List<Album> findAllByAnyoLanzamiento(int anyoLanzamiento);
	//Album findByIdCodigo(int idCodigo);
}
