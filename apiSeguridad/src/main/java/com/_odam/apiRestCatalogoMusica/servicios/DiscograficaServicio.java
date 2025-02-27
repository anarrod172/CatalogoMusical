package com._odam.apiRestCatalogoMusica.servicios;

import java.util.List;

import com._odam.apiRestCatalogoMusica.modelos.Discografica;

public interface DiscograficaServicio {
	
	Discografica altaDiscografica(Discografica discografica);
	List<Discografica> mostrarListaDiscografica();
	Discografica mostrarDiscografica(Integer idDiscografica);
	Discografica actualizarTelefono(Integer idDiscografica, String telefono);
	List<Discografica> filtrarDiscograficaPorNombre(String nombre);
}
