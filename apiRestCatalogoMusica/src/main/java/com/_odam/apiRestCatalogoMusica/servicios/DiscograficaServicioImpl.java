package com._odam.apiRestCatalogoMusica.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._odam.apiRestCatalogoMusica.excepciones.DiscograficaNotFound;
import com._odam.apiRestCatalogoMusica.modelos.Discografica;
import com._odam.apiRestCatalogoMusica.repositorios.DiscograficaRepositorio;


@Service
public class DiscograficaServicioImpl implements DiscograficaServicio {
	
	//Inyectar el repositorio
	@Autowired
	private DiscograficaRepositorio discograficaRepo;
	
	
	//Dar de alta discografica
	@Override
	public Discografica altaDiscografica(Discografica discografica) {
		return discograficaRepo.save(discografica);
	}
	
	//Mostrar todas las discográficas
	@Override
	public List<Discografica> mostrarListaDiscografica() {
		List<Discografica> listadoDiscografica = discograficaRepo.findAll();	
		List<Discografica> discograficas = new ArrayList<Discografica>();
		for(Discografica discografica:listadoDiscografica) {
			discograficas.add(discografica);
		}
		return discograficas;
	}
	
	//Consultar la discográfica por su id
	@Override
	public Discografica mostrarDiscografica(Integer idDiscografica) throws DiscograficaNotFound {
		Discografica discografica = discograficaRepo.findById(idDiscografica).orElseThrow(
				()-> new DiscograficaNotFound(idDiscografica)
				);
		return discografica;
		
	}

	//Modificar el teléfono de la discográfica
	@Override
	public Discografica actualizarTelefono(Integer idDiscografica, String telefono) throws DiscograficaNotFound {
		Discografica discograficaSinActualizar = discograficaRepo.findById(idDiscografica).orElseThrow(
				()-> new DiscograficaNotFound(idDiscografica)
				);
		discograficaSinActualizar.setTelefono(telefono);
		Discografica discograficaActualizada = discograficaRepo.save(discograficaSinActualizar);
		return discograficaActualizada;
	}
	
	//Filtrar discografica por su nombre
	@Override
	public List<Discografica> filtrarDiscograficaPorNombre(String nombre) {
		return discograficaRepo.findByNombre(nombre);
	}
}
