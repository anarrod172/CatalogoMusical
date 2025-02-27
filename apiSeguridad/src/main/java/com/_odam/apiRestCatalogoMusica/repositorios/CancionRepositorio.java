package com._odam.apiRestCatalogoMusica.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._odam.apiRestCatalogoMusica.modelos.Cancion;


@Repository
public interface CancionRepositorio extends JpaRepository<Cancion, Integer>{
	
	List<Cancion> findAllByTitulo(String titulo);
	Cancion findByTitulo(String titulo);
	//Cancion findById(Integer idCodigo);
}
