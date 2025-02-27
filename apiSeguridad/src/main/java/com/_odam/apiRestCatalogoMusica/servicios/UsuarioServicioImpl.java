package com._odam.apiRestCatalogoMusica.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com._odam.apiRestCatalogoMusica.modelos.Usuario;
import com._odam.apiRestCatalogoMusica.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Override
	public UserDetails loadUserByUsername(String username) {
		return (UserDetails) usuarioRepositorio.findByUsuario(username);
	}

	@Override
	public Usuario existsByUsuario(String nombre) {
		return usuarioRepositorio.findByUsuario(nombre);
	}

	@Override
	public void saveUsuario(Usuario u) {
		usuarioRepositorio.save(u);
	}

}
