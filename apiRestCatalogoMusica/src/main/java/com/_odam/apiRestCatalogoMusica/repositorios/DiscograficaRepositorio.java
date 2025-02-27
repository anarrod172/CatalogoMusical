package com._odam.apiRestCatalogoMusica.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._odam.apiRestCatalogoMusica.modelos.Discografica;


@Repository
public interface DiscograficaRepositorio extends JpaRepository<Discografica, Integer>{
	
	List<Discografica> findAll();
	Discografica findDiscograficaByIdDiscografica(Integer idDiscografica);
	List<Discografica> findByNombre(String nombre);
}
